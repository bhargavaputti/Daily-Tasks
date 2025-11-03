# Question - DynamoDB, EC2, API Gateway and Lambda
### Assignment Overview
 Create a serverless web application that does CRUD  operation on data through an HTML form hosted on EC2, processes it via Lambda functions, and stores it in DynamoDB.
### Architecture Components
EC2 Instance: Hosts a static HTML form
API Gateway: REST API endpoint
Lambda Functions: Process form data
DynamoDB: Stores submitted form data
IAM Roles: Secure permissions between services
### Detailed Requirements
1. DynamoDB Table Design
Create a table named UserSubmissions with:
Partition Key: submissionId (String)
Attributes: name, email, message, submissionDate, status
2. Lambda Functions
Create two Lambda functions
Submission Lambda:
Triggered by API Gateway POST request
Validates input data
Generates unique submissionId
Stores data in DynamoDB
Returns success/error response
Query Lambda:
Triggered by API Gateway GET request
Retrieves submissions from DynamoDB
Supports querying by email or fetching all records
3. API Gateway
REST API with two resources:
POST /submit → Submission Lambda
GET /submissions → Query Lambda
Enable CORS for EC2 domain
4. EC2 Instance
Launch t2.micro instance with Amazon Linux
Install web server (Apache/Nginx)
Host static HTML form with fields:
Name (text, required)
Email (email, required)
Message (textarea, required)
JavaScript to handle form submission to API Gateway
5. IAM Roles
Lambda execution role with DynamoDB read/write permissions
EC2 instance profile (if needed)
Note: The HTML form should use CSS and Bootstrap.
# Solution
## DynamoDB
<img width="1331" height="555" alt="image" src="https://github.com/user-attachments/assets/4cf9317e-17c7-41c4-917a-0d55d7927070" />


## Lambda 
### Submission Lambda
<img width="1327" height="475" alt="image" src="https://github.com/user-attachments/assets/79facb49-d7e9-474b-999c-ee89cbccbdb7" />


### Query Lambda
<img width="1347" height="464" alt="image" src="https://github.com/user-attachments/assets/f843a3ad-dfae-4679-990e-e541110add24" />



## API Gateway

<img width="1336" height="468" alt="image" src="https://github.com/user-attachments/assets/e8873524-23ef-44c1-868d-4973a80b3819" />

# Output
<img width="1146" height="567" alt="Screenshot 2025-11-03 123045" src="https://github.com/user-attachments/assets/c67c57fc-4a8d-425d-a868-1ef79ccb934a" />

