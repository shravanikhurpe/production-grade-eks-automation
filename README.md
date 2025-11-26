Production-Grade EKS Automation with Jenkins and Terraform

This repository contains a production-ready DevOps workflow that provisions AWS EKS clusters using Terraform, builds and pushes Docker images to Amazon ECR, and automates application deployment via Jenkins.
It demonstrates an end-to-end real-world CI/CD + Infrastructure-as-Code pipeline suitable for cloud-native applications.

1. Overview

This project includes:

Automated EKS cluster provisioning using Terraform

Docker-based application containerization

CI/CD pipeline using Jenkins (Groovy pipeline)

Kubernetes deployment and service manifests

Monitoring setup using Prometheus

Namespace-based application isolation

End-to-end automation from infrastructure → build → deploy

This setup reflects how production DevOps teams manage cloud-native workloads.

2. Architecture Summary

Technologies Used

AWS EKS

Terraform

Jenkins (Groovy scripted pipeline)

Docker

Amazon ECR

Kubernetes (kubectl)

Prometheus (basic monitoring)

Pipeline Flow

Checkout source code

Terraform init, plan, and apply to provision EKS cluster

Build Docker image

Authenticate and push image to ECR

Deploy Kubernetes manifests to the EKS cluster

Configure monitoring

3. Repository Structure
Terraform Infrastructure (terraform-eks-infra/)

backend.tf

data.tf

eks.tf

provider.tf

vpc.tf

variables.tf

variables/

dev.tfvars

prod.tfvars

test.tfvars

Jenkins Configuration (jenkins-config/)

scripts/

install_build_tools.sh

Kubernetes Manifests (k8s-manifests/)

deployment.yaml

service.yaml

Monitoring (monitoring/)

prometheus-config.yaml

CI/CD Pipeline

CI-CD-pipeline.groovy

Application Container

Dockerfile

Additional Files

changelog.txt

README.md

image.png

4. Terraform Infrastructure Features

Automated provisioning of AWS VPC

Public and private subnets

Route tables and Internet Gateway

EKS cluster creation

Managed node groups

IAM roles and policies

Environment-specific variable files (dev, prod, test)

5. CI/CD Pipeline Features

The Jenkins Groovy pipeline includes:

Source code checkout

Terraform initialization

Terraform plan and apply

Docker image build

ECR authentication

Docker image push

Kubernetes deployment rollout

Monitoring setup

This pipeline fully automates infrastructure + deployment.

6. Kubernetes Deployment Features

Deployment manifest for application pod replicas

Service manifest for internal/external access

Namespace-based isolation for cleaner environments

kubectl rollout automation via Jenkins

7. Monitoring Setup

Prometheus config is included under the monitoring directory.
It tracks:

Pod metrics

Cluster resource usage

Basic application availability

This provides visibility into the deployed workload.

8. How to Use This Project
Prerequisites

AWS CLI configured

Terraform installed

Docker installed

Jenkins server available

kubectl installed

IAM permissions for EKS, EC2, VPC, ECR

Local Setup
terraform init
terraform plan -var-file=variables/dev.tfvars
terraform apply -var-file=variables/dev.tfvars -auto-approve

Build & Push Docker Image
docker build -t eks-app .
docker tag eks-app:latest <AWS_ACCOUNT_ID>.dkr.ecr.<region>.amazonaws.com/eks-app:latest
docker push <AWS_ACCOUNT_ID>.dkr.ecr.<region>.amazonaws.com/eks-app:latest

Deploy to Kubernetes
kubectl apply -f k8s-manifests/deployment.yaml
kubectl apply -f k8s-manifests/service.yaml
