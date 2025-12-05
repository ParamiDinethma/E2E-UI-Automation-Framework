# 🚀 E2E UI Automation Framework (Java, Selenium, TestNG)

## 🌟 Project Overview

This project implements a robust End-to-End (E2E) UI test automation framework for the Sauce Labs Demo E-commerce Inventory Management Application using industry-standard tools.

The goal is to ensure the critical business flows—User Authentication and Product Purchase—are stable and defect-free across deployments.

## 🛠️ Technology Stack

This framework utilizes the following technologies and design patterns:

| Category | Tool / Language | Purpose |
| :--- | :--- | :--- |
| **Language** | Java | Core programming language for the automation logic. |
| **Framework** | Selenium WebDriver | Interacts with the browser (Chrome/Edge/Firefox) to simulate user actions. |
| **Test Runner** | TestNG | Provides annotations for structuring tests (`@Test`, `@BeforeMethod`) and generating detailed reports. |
| **Build Tool** | Maven | Manages project dependencies (Selenium, TestNG) and handles the build lifecycle. |
| **Design Pattern** | Page Object Model (POM) | Separates test logic from element locators for code maintenance and reusability. 

[Image of Page Object Model diagram]
 |

## ⚙️ Prerequisites

To run this project, you need the following installed:

* **Java Development Kit (JDK) [Specify Version, e.g., 17 or higher]**
* **Apache Maven**
* An Integrated Development Environment (IDE) like **IntelliJ IDEA** or **VS Code**
* A browser like **Google Chrome** (Selenium will automatically manage the driver, but the browser must be installed).

## 🚀 Execution Instructions

Follow these steps to clone the repository and run the automated test suite.

### 1. Clone the Repository

```bash
git clone (https://github.com/ParamiDinethma/E2E-UI-Automation-Framework-Java-Selenium-TestNG-.git)
cd E2E-UI-Automation-Framework-Java-Selenium-TestNG
