# Tudasbazis


## Required pages/forms

### /login/loginForm.html
username, password and submit.
Action redirects to: /login

### /login/logoutForm.html
submit(with logout label).
Action redirects to: /logout

### /article/postForm.html
title, content, keywords, language(select), language(select), category(select)
Action redirects to: /article/post

### /report/reportFrom.html
description
Action redirects to: /report/send

##Functional urls
/
/login
/logout
/article/read/{articleId}
/article/post
/article/review/accept/{articleId}
/article/review/decline/{articleId}


## How to Build/Run the project
### Run
```mvn -q spring-boot:run```
### Build
```mvn clean package```
