## EP1 控制器的编写和数据绑定

### 新建工程

若无法连接到官方 Spring Initializr，可更换到国内站点 https://start.springboot.io/

- Spring Web
- Spring Validation
- MySQL Driver
- Lombok

```xml
<maven.compiler.source>17</maven.compiler.source>
<maven.compiler.target>17</maven.compiler.target>
<parameters>true</parameters>
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
```

### 编写一个控制器

#### 什么是“控制器”（Controller）

在 Spring Boot 中，**控制器是处理用户请求的入口**。

你可以把它想象成一个网站或接口的“接待员”：
👉 用户发来请求，控制器接收、处理，然后返回响应。

#### @RestController 是什么

```java
@RestController = @Controller + @ResponseBody
```

用来告诉 Spring 这个类是一个控制器（用来接收 Web 请求），并且返回的是 JSON 数据（而不是 HTML 页面）

#### @RequestMapping 是什么

告诉 Spring，这个类负责处理哪个 URL 请求

常用方法：加在类上，定义“公共前缀”

### 数据绑定

#### Query 参数绑定

```java
@GetMapping("/get")
public String get(@RequestParam("name") String name) {
    return name;
}
```

#### 路径参数绑定

```java
@GetMapping("/get/{name}")
public String get(@PathVariable("name") String name) {
    return name;
}
```

#### 绑定 Query 或表单到对象

```java
@Data
public class User {
    private String name;
    private Integer age;
}

@GetMapping("/get")
public String get(User user) {
    return user.toString();
}
```

#### 绑定 JSON 到对象
```java
@Data
public class User {
    @JsonProperty("first_name")
    private String firstName;
    private Integer age;
}

@PostMapping("/post")
public String post(@RequestBody User user) {
    return user.toString();
}
```

### 参数校验

```java
@NotNull、@NotEmpty、@NotBlank

@Size、@Email

@Min、@Max
```

### 统一 JSON 响应体

```java
@Data
@AllArgsConstructor
public class AjaxResult<T> {
    public static final String SUCCESS_MSG = "OK";
    private Integer code;
    private String msg;
    private T data;

    public static <N> AjaxResult<N> success() {
        return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MSG, null);
    }

    public static <N> AjaxResult<N> success(N data) {
        return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MSG, data);
    }

    public static <N> AjaxResult<N> fail(Integer code, String msg) {
        return new AjaxResult<>(code, msg, null);
    }
}
```