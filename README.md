

# **Production-Ready Kubernetes Deployment Automation with CI/CD**

This project implements a production-style DevOps workflow by automating Kubernetes deployments using **Terraform, Docker, Jenkins, and Kubernetes manifests**. It demonstrates full infrastructure automation, containerization, CI/CD integration, and Kubernetes orchestration in a modular, scalable setup.

---

# **Project Overview**

This repository contains an **end-to-end automation pipeline** for deploying containerized applications on Kubernetes.
It covers:

* Infrastructure provisioning using **Terraform**
* Containerization using **Docker**
* Continuous Integration & Delivery using **Jenkins**
* Application deployment via **Kubernetes manifests**
* Monitoring setup using **Prometheus**

This structure mirrors real-world enterprise DevOps practices.

---

# **Architecture**

```
                 ┌───────────────────────────┐
                 │           GitHub           │
                 └───────────────┬───────────┘
                                 │  (Push Code)
                                 ▼
                        ┌────────────────┐
                        │    Jenkins CI  │
                        └───────┬────────┘
                                │
                      Build + Test + Dockerize
                                │
                                ▼
                    ┌──────────────────────┐
                    │   Docker Registry    │
                    └──────────┬───────────┘
                               │
                      Terraform Provisioning
                               │
                               ▼
                   ┌─────────────────────┐
                   │   Kubernetes Cluster │
                   │ (Minikube / K8s)     │
                   └──────────┬───────────┘
                              │
                         Deploy Application
                              │
                              ▼
                 ┌───────────────────────────┐
                 │   Monitoring (Prometheus)  │
                 └───────────────────────────┘
```

---

# **Tech Stack**

### DevOps & CI/CD

* Jenkins
* Jenkinsfile (Declarative Pipeline)
* GitHub

### Infrastructure as Code

* Terraform
* Terraform Modules

### Containerization & Orchestration

* Docker
* Kubernetes (K8s)
* Minikube
* kubectl

### Monitoring

* Prometheus

---

# **Project Structure**

```
production-ready-k8s-deployment-automation-cicd/
│
├── jenkins/
│   └── Jenkinsfile
│
├── terraform/
│   ├── main.tf
│   ├── variables.tf
│   ├── outputs.tf
│   └── provider.tf
│
├── k8s-manifests/
│   ├── deployment.yaml
│   ├── service.yaml
│   ├── configmap.yaml
│   └── ingress.yaml
│
├── Dockerfile
├── scripts/
└── README.md
```

---

# **Key Features**

### 1. Kubernetes Infrastructure Automation

Provision Kubernetes resources and environments using **Terraform** for reproducibility and standardization.

### 2. CI/CD Pipeline

Jenkins automates build, test, containerization, and deployment workflows.

### 3. Kubernetes Deployment

Production-style Kubernetes manifests for deployments, services, ingress, config maps, and updates.

### 4. Monitoring Integration

Prometheus setup for monitoring metrics and cluster health.

---

# **How to Run the Project**

### 1. Clone the Repository

```bash
git clone https://github.com/shravanikhurpe/production-ready-k8s-deployment-automation-cicd.git
cd production-ready-k8s-deployment-automation-cicd
```

### 2. Start Minikube

```bash
minikube start
```

### 3. Apply Terraform Infrastructure

```bash
cd terraform
terraform init
terraform apply
```

### 4. Build Docker Image

```bash
docker build -t <your-image> .
```

### 5. Deploy to Kubernetes

```bash
kubectl apply -f k8s-manifests/
```

### 6. Run Jenkins Pipeline

Configure Jenkins, connect repository, and run the pipeline to enable automated deployment.

---

# **CI/CD Workflow Summary**

1. Code pushed to GitHub
2. Jenkins triggers pipeline
3. Application is built and containerized
4. Docker image pushed to registry
5. Terraform provisions/updates infra
6. Kubernetes deployment applied
7. Prometheus monitors resources

---

# **Conclusion**

This project demonstrates the complete DevOps lifecycle, combining:

* Infrastructure as Code
* CI/CD automation
* Containerization
* Kubernetes deployment
* Monitoring

---
