## Setup
1. Setup MySql database with docker.
`docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=budgetAppDB --name budget-app-db mysql:8.0`