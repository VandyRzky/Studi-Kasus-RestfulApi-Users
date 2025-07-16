# API Spec

## User Spec

### Register User

- Endpoint: POST /api/users
- Request Body:
```json
{
  "username" : "contohUsername",
  "password" : "ContohPassword",
  "name": "Contoh name"
}
```
- Response Body (Success):
```json
{
  "data": "Registrasi berhasil"
}
```
- Response Body (Failed):
```json
{
  "error": "Username/password error"
}
```

### Login User

- Endpoint: GET /api/auth/login
- Request Body:
```json
{
  "username" : "contohUsername",
  "password" : "ContohPassword"
}
```
- Response Body (Success):
```json
{
  "data": {
    "token": "TOKEN",
    "expireAt": 111111111 // millisecond
  }
}
```
- Response Body (Failed):
```json
{
  "error": "Username/password wrong"
}
```

### Update User

- Endpoint: PATCH /api/users/current
- Request Header:
  - X-API-Token : token (Mandatory)
- Request Body:
```json
{
  "username" : "contohUsername", //diisi ketika akan di update
  "password" : "ContohPassword" //diisi ketika akan di update
}
```
- Response Body (Success):
```json
{
  "data":{
    "username" : "contohUsername",
    "name": "contoh Name"
  }
}
```
- Response Body (Failed):
```json
{
  "data": null,
  "error": "gagal melakukan update"
}
```

### Get User

- Endpoint: GET /api/users/current
- Request Header: 
  - X-API-Token : token (Mandatory)
- Response Body (Success):
```json
{
  "data": {
    "username" : "contohUsername",
    "name": "contoh Name"
  }
}
```
- Response Body (Failed):
```json
{
  "error": "Belum Login"
}
```

### Logout User

- Endpoint: DELETE /api/auth/logout
- Request Header:
    - X-API-Token : token (Mandatory)
- Response Body (Success):
```json
{
  "data": "OK"
}
```