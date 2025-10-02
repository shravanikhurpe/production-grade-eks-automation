pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Terraform Init') {
            steps {
                sh '''
                    cd terraform-eks-infra
                    terraform init
                '''
            }
        }

        stage('Terraform Plan') {
            steps {
                sh '''
                    cd terraform-eks-infra
                    terraform plan -var-file=variables/dev.tfvars
                '''
            }
        }

        stage('Create/Update EKS Cluster') {
            steps {
                sh '''
                    cd terraform-eks-infra
                    terraform apply -var-file=variables/dev.tfvars -auto-approve
                '''
            }
        }

        stage('Deploy Kubernetes Application') {
            steps {
                sh '''
                    cd manifest
                    kubectl apply -f deployment.yaml
                    kubectl apply -f service.yaml
                '''
            }
        }

        stage('Push Image to ECR') {
            steps {
                sh '''
                    # Authenticate to ECR
                    aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin $AWS_ACCOUNT_ID.dkr.ecr.ap-south-1.amazonaws.com

                    # Build Docker image
                    docker build -t eks-app .

                    # Tag Docker image
                    docker tag eks-app:latest $AWS_ACCOUNT_ID.dkr.ecr.ap-south-1.amazonaws.com/eks-app:latest

                    # Push image to ECR
                    docker push $AWS_ACCOUNT_ID.dkr.ecr.ap-south-1.amazonaws.com/eks-app:latest
                '''
            }
        }

    }
}

/* added ECR login and image push steps - Oct 19 */
