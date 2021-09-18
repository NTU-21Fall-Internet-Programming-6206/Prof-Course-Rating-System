# Professor-Course-Rating-Application API文档

RESTful API

URL: http://127.0.0.1:8585/

在用户登录获得token后，后续其他所有请求都要在请求头Header中添加 `Authorization = TOKEN_STRING`;

GET请求，参数体现在url上。所有查询（获取）请求用GET；

POST请求，用json将参数放在请求体Body里。所有创建请求用POST；

DELETE请求，参数体现在url上。所有删除请求用DELETE；

- [Professor-Course-Rating-Application API文档](#professor-course-rating-application-api文档)
  - [全局错误码](#全局错误码)
  - [Student](#student)
    - [Student注册](#student注册)
    - [Student登录](#student登录)
  - [Professor](#professor)
    - [获取Professor信息](#获取professor信息)
  - [Course](#course)
    - [创建Course](#创建course)
    - [获取Course信息](#获取course信息)
  - [对教授的C&R](#对教授的cr)
    - [创建对教授的C&R](#创建对教授的cr)
    - [获取对教授的C&R](#获取对教授的cr)
    - [删除对教授的C&R](#删除对教授的cr)
  - [对课程的C&R](#对课程的cr)
    - [创建对课程的C&R](#创建对课程的cr)
    - [获取对课程的C&R](#获取对课程的cr)
    - [删除对课程的C&R](#删除对课程的cr)

## 全局错误码

| 错误码 | 错误解释     |
|--------|----------|
| 404   | 接口不存在 |
| 500   | 服务器错误     |

## Student

### Student注册

**请求URL：** 
- `http://127.0.0.1:8585/student/register`
  
**请求方式：**
- POST 

**参数：** 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|username |是  |string |用户名   |
|password |是  |string |密码    |
|email_address     |是  |string | 邮箱地址|

 **返回示例**
```json
  {
    "info": "Success",
  }
```
 **返回参数说明** 

|参数名|类型|说明|
|:-----  |:-----|-----                           |
|info |string   |"Success"表示注册成功；若失败，为失败详细说明。  |

### Student登录

**请求URL：** 
- `http://127.0.0.1:8585/student/login`
  
**请求方式：**
- POST 

**参数：** 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|username |是  |string |用户名   |
|password |是  |string |密码    |

 **返回示例**
```json
  {
    "info": "Success",
    "token": "b6aaed9f3f669su8b6aaed9f3f669su8"
  }
```
 **返回参数说明** 

|参数名|类型|说明|
|:-----  |:-----|-----                           |
|info |string   |"Success"表示登录成功；若失败，为失败详细说明。  |
|token |string   |若登录成功，返回含32个字符的字符串作为token；若失败，为空字符串。|


## Professor

### 获取Professor信息

**请求URL：** 
- `http://127.0.0.1:8585/professor`
  
**请求方式：**
- GET 

**参数：** 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|professor_name |否  |string |教授名。若有该参数，返回该教授的信息；若无此参数，返回所有教授的信息   |


 **返回示例**
```json
  {
    "professor_list": [
      {
        "professor_name": "professor_1",
        "title": "Professor", 
        "email_address": "abc@ntu.edu.sg"
      }, 
      {
        "professor_name": "professor_2",
        "title": "Professor", 
        "email_address": "def@ntu.edu.sg"
      },
    ]
  }
```
 **返回参数说明** 

|参数名|类型|说明|
|:-----  |:-----|-----|
|professor_list |list   |其中每个元素是单个教授的信息。|




## Course

### 创建Course

### 获取Course信息




## 对教授的C&R

### 创建对教授的C&R

### 获取对教授的C&R

### 删除对教授的C&R




## 对课程的C&R

### 创建对课程的C&R

### 获取对课程的C&R

### 删除对课程的C&R

