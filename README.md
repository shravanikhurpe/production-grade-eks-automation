Production-Grade EKS Automation with Jenkins and Terraform

This repository demonstrates a production-ready pipeline for provisioning Amazon EKS clusters, deploying containerized applications, and automating the CI/CD process using Jenkins and Terraform.

1. Overview

This project covers:

Infrastructure provisioning using Terraform

Amazon EKS cluster setup

Docker-based application containerization

Image storage in Amazon ECR

Kubernetes application deployment

Jenkins-driven CI/CD automation

Monitoring using Prometheus and Grafana

2. Architecture Summary
Infrastructure

AWS VPC, subnets, routing

EKS cluster with managed node groups

IAM roles and permissions

Terraform backend, variables, and environment-based tfvars

Application & Deployment

Dockerfile for application image

Kubernetes Deployment and Service manifests

Namespace-based isolation

CI/CD Pipeline

Terraform init / plan / apply

Docker build, tag, and push to ECR

Kubernetes rollout via kubectl

Groovy-based Jenkins pipeline

3. Repository Structure
production-grade-eks-automation
├── terraform-eks-infra
│   ├── backend.tf
│   ├── data.tf
│   ├── eks.tf
│   ├── provider.tf
│   ├── vpc.tf
│   ├── variables.tf
│   └── variables
│       ├── dev.tfvars
│       ├── prod.tfvars
│       └── test.tfvars
│
├── jenkins-config
│   └── scripts
│       └── install_build_tools.sh
│
├── k8s-manifests
│   ├── deployment.yaml
│   └── service.yaml
│
├── monitoring
│   └── prometheus-config.yaml
│
├── CI-CD-pipeline.groovy
├── Dockerfile
├── changelog.txt
└── README.md

4. Features
Terraform Infrastructure

Automated VPC creation

Public / private subnets

Route tables and IGW

EKS cluster provisioning

Managed node groups

IAM roles and permissions

Application Deployment

Build application container using Docker

Deployment and Service for Kubernetes

Rollout strategy using Kubernetes

CI/CD Automation (Jenkins)

Repository checkout

Terraform execution

Docker build + ECR push

kubectl-based rolling deployment

End-to-end automated delivery

Monitoring

Prometheus configuration

Grafana-ready metrics

5. Jenkins Pipeline Workflow

The CI/CD pipeline performs:

Check out source code

Run Terraform init

Run Terraform plan

Apply infrastructure changes

Build Docker image

Push image to AWS ECR

Deploy application to EKS

Apply Kubernetes manifests

Pipeline definition is in:
CI-CD-pipeline.groovy

6. Prerequisites

Ensure the following tools are installed:

AWS CLI

Terraform

Docker

kubectl

Jenkins

IAM permissions for EKS, EC2, ECR

7. Usage
1. Initialize Terraform
cd terraform-eks-infra
terraform init

2. Apply infrastructure
terraform apply -var-file=variables/dev.tfvars

3. Update kubeconfig
aws eks update-kubeconfig --name <cluster-name>

4. Build and push Docker image
docker build -t eks-app .
docker tag eks-app:latest <AWS_ID>.dkr.ecr.<region>.amazonaws.com/eks-app:latest
docker push <AWS_ID>.dkr.ecr.<region>.amazonaws.com/eks-app:latest

5. Deploy to Kubernetes
kubectl apply -f k8s-manifests/deployment.yaml
kubectl apply -f k8s-manifests/service.yaml

6. Trigger Jenkins pipeline
