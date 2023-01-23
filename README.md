# Rest Api Java Spring Boot

Create simple Rest Api with spring boot with implement JWT (JSON Web Token)

# Features
- Register
- Authentication login
- get all job data
- get job details

# Tech
- Java
- Spring Boot
- Maven
- JWT
- MySQL

# Installation
- Run MySQL on port 3306

- Run application with :
```
mvn spring-boot:run
```
this command will run the application on port 8080 and generate database (dansmultipro) and table (user)
![image](https://user-images.githubusercontent.com/61193419/214076659-7633c5ad-1922-4452-b53b-797d9566efad.png)
![image](https://user-images.githubusercontent.com/61193419/214076895-9e1be3ab-b875-49b5-aba3-cb24e4a5e05f.png)


# Testing
- **Registration**
![image](https://user-images.githubusercontent.com/61193419/214077871-1db4fb3f-0a12-466f-9a82-6809deb2c4a4.png)

- **Authenticate login**
![image](https://user-images.githubusercontent.com/61193419/214078086-88a5bbab-16ef-4dd1-9a04-295ae5e20083.png)
from this endpoint, will be return a random string (token) to use in Authentication Bearer form. 
<br />

- **Get job data** <br />
![image](https://user-images.githubusercontent.com/61193419/214080507-91899cdb-c030-4ee0-894c-885b8f282bc6.png)
![image](https://user-images.githubusercontent.com/61193419/214081391-55c7e379-77c3-481c-98d3-5fe514af163f.png)
<br />

- **Get job details, response "id" from endpoint ../job will be passing on path variable** <br />
![image](https://user-images.githubusercontent.com/61193419/214081794-2b339a02-bb8d-48f3-9164-8c2e72dcd299.png)
<br />

- **Wrong Token**
if put wrong token will throw 401 Http status
![image](https://user-images.githubusercontent.com/61193419/214083406-4a99874e-1122-4b01-98bb-712a35f4c9bf.png)
