# Professor-Course-Rating-Application API文档

RESTful API

URL: http://34.126.85.190:8080/

在用户登录获得token后，后续其他所有请求都要在请求头Header中添加 `Token = TOKEN_STRING`;

GET请求，参数体现在url上。所有查询（获取）请求用GET；

POST请求，用json将参数放在请求体Body里。所有创建请求用POST；

DELETE请求，参数体现在url上。所有删除请求用DELETE；

- [Professor-Course-Rating-Application API文档](#professor-course-rating-application-api文档)
  - [一、全局错误码](#一全局错误码)
  - [二、Student](#二student)
    - [1. Student注册](#1-student注册)
    - [2. Student登录](#2-student登录)
  - [三、Professor](#三professor)
    - [1. 获取Professor信息](#1-获取professor信息)
  - [四、Course](#四course)
    - [1. 创建Course](#1-创建course)
    - [2. 获取Course信息](#2-获取course信息)
  - [五、对教授的C&R](#五对教授的cr)
    - [1. 创建对教授的C&R](#1-创建对教授的cr)
    - [2. 获取对教授的C&R](#2-获取对教授的cr)
    - [3. 删除对教授的C&R](#3-删除对教授的cr)
  - [六、对课程的C&R](#六对课程的cr)
    - [1. 创建对课程的C&R](#1-创建对课程的cr)
    - [2. 获取对课程的C&R（会删除该用户对该教授所有的C&R）](#2-获取对课程的cr会删除该用户对该教授所有的cr)
    - [3. 删除对课程的C&R（会删除该用户对该课程所有的C&R）](#3-删除对课程的cr会删除该用户对该课程所有的cr)

## 一、全局错误码

| 错误码 | 错误解释     |
|--------|----------|
| 404   | 接口不存在 |
| 500   | 服务器错误     |

## 二、Student

### 1. Student注册

请求URL： 
- `http://34.126.85.190:8080/student/register`
  

请求方式：
- POST 

参数： 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|username |是  |string |用户名   |
|password |是  |string |密码    |
|email_address     |是  |string | 邮箱地址|

 返回示例
```json
  {
    "info": "Success"
  }
```
 返回参数说明 

|参数名|类型|说明|
|:-----  |:-----|-----                           |
|info |string   |"Success"表示注册成功；若失败，为失败详细说明。  |

### 2. Student登录

请求URL： 
- `http://34.126.85.190:8080/student/login`
  

请求方式：
- POST 

参数： 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|username |是  |string |用户名   |
|password |是  |string |密码    |

 返回示例
```json
  {
    "info": "Success",
    "token": "b6aaed9f3f669su8b6aaed9f3f669su8", 
    "username": "userA"
  }
```
 返回参数说明 

|参数名|类型|说明|
|:-----  |:-----|-----                           |
|info |string   |"Success"表示登录成功；若失败，为失败详细说明。  |
|token |string   |若登录成功，返回含32个字符的字符串作为token；若失败，为空字符串。|
|username |string   |若登录成功，返回该用户的用户名；若失败，为空字符串。|



## 三、Professor

### 1. 获取Professor信息

请求URL： 
- `http://34.126.85.190:8080/professor?professor_name=Gerard Goggin`

请求方式：
- GET 

参数： 

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|professor_name |否  |string |教授名。若有该参数，返回该教授的信息；若无此参数，返回所有教授的信息   |


 返回示例	
```json
{
    "professor_list": {
        "emailAddress": "gerard.goggin@ntu.edu.sg",
        "professorName": "Gerard Goggin",
        "title": "Professor"
    }
}
```
 返回参数说明 

|参数名|类型|说明|
|:-----  |:-----|-----|
|professor_list |list   |其中每个元素是单个教授的信息。|

## 四、Course

### 1. 创建Course

请求URL:

- `http://34.126.85.190:8080/course/add`
  

请求方式：

- POST

参数:

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|course_id |是  |string |课程ID   |
|professor_name |是  |string |教授名   |
|course_name |是  |string |课程名    |

 返回示例:

```json
  {
    "info": "Success"
  }
```

 返回参数说明:

|参数名|类型|说明|
|:-----  |:-----|-----                           |
|info |string   |"Success"表示创建；若失败，为失败详细说明。  |

### 2. 获取Course信息

> 用可选参数实现：获取全部course信息、获取某个教授对应的全部course信息、获取某一个特定course信息

请求URL:

- `http://34.126.85.190:8080/course?professor_name=Alton Chua Yeow Kuan`

请求方式：

- GET

参数:

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|course_name |否  |string |课程名。若有该参数，返回课程名为该课程的信息（可能课程同名但不同教授）；|
|professor_name |否  |string |教授名。若有该参数，返回该教授的课程信息；|

 返回示例

```json
{
    "course_list": [
        {
            "courseID": "CI6204",
            "courseName": "Software Project Management",
            "professorName": "Alton Chua Yeow Kuan"
        }
    ]
}
```

 返回参数说明

|参数名|类型|说明|
|:-----  |:-----|-----|
|course_list |list   |其中每个元素是单个课程的信息。|

## 五、对教授的C&R

### 1. 创建对教授的C&R

请求URL:

- `http://34.126.85.190:8080/professor-CR/add`
  

请求方式：

- POST

参数:

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|professor_name |是  |string |教授名   |
|username |是  |string |用户名    |
|rate     |是  |integer | 评分|
|comment     |是  |string | 评价|

 返回示例

```json
  {
    "info": "Success"
  }
```

 返回参数说明

|参数名|类型|说明|
|:-----  |:-----|-----                           |
|info |string   |"Success"表示创建成功；若失败，为失败详细说明。  |

### 2. 获取对教授的C&R

请求URL:

- `http://34.126.85.190:8080/professor-CR?professor_name=Alton Chua Yeow Kuan`

请求方式：

- GET

参数:

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|professor_name |是  |string |教授名。返回该教授的C&R.|

 返回示例

```json

```

 返回参数说明

|参数名|类型|说明|
|:-----  |:-----|-----|
|professor_cr_list |list   |其中每个元素是单个教授的C&R。|

### 3. 删除对教授的C&R

请求URL:

- `http://34.126.85.190:8080/professor`
  

请求方式：

- DELETE

参数:

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|professor_name |是  |string |教授名   |
|username |是  |string |用户名    |

 返回示例

 ```json
  {
    "info": "Success"
  }
 ```

 返回参数说明

|参数名|类型|说明|
|:-----  |:-----|-----                           |
|info |string   |"Success"表示删除成功；若失败，为失败详细说明。  |

## 六、对课程的C&R

### 1. 创建对课程的C&R

请求 URL：

* `http://34.126.85.190:8080/course-CR/add`

请求方式：

* POST

参数：

| 参数名         | 必选 | 类型   | 说明    |
| -------------- | ---- | ------ | ------- |
| professor_name | 是   | string | 教授名  |
| username       | 是   | string | 用户名  |
| course_id      | 是   | string | 课程 id |
| rate           | 是   | int    | 评分    |
| comment        | 否   | string | 评价    |

返回方式：

```json
{
    "info": "Success"
}
```

返回参数说明：

| 参数 | 类型   | 说明                                            |
| ---- | ------ | ----------------------------------------------- |
| info | string | "Success"表示创建成功；若失败，为失败详细说明。 |

### 2. 获取对课程的C&R（会删除该用户对该教授所有的C&R）

请求 URL：

* `http://34.126.85.190:8080/course-CR`

请求方式：

* GET

参数：

| 参数      | 必选 | 类型   | 说明    |
| --------- | ---- | ------ | ------- |
| course_id | 是   | string | 课程 id |

返回示例：

```json
  {
    "course_cr_list": [
      {
        "professor_name": "professor_1",
        "username": "abc123",
        "course_id": "ci6206",
        "rate": 3,
        "comment": "boring"
      }, 
      {
        "professor_name": "professor_2",
        "username": "jojo123", 
        "course_id": "ci6208",
        "rate": 2,
        "comment": "great"
      },
    ]
  }
```

返回参数说明：

| 参数           | 类型 | 说明                        |
| -------------- | ---- | --------------------------- |
| course_cr_list | list | 其中每个元素是单个课程的C&R |

### 3. 删除对课程的C&R（会删除该用户对该课程所有的C&R）

请求 URL：

* `http://34.126.85.190:8080/course`

请求方式：

* DELETE

参数名：

| 参数      | 必选 | 类型   | 说明    |
| --------- | ---- | ------ | ------- |
| course_id | 是   | string | 课程 id |
| username  | 是   | string | 用户名  |

返回示例：

```json
{
    "info": "Success"
}
```

返回参数说明：

| 参数 | 类型   | 说明                                            |
| ---- | ------ | ----------------------------------------------- |
| info | string | "Success"表示删除成功；若失败，为失败详细说明。 |

