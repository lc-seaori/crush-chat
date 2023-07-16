# SaToken使用

## Sa-Token 数据存储有三大作用域
1. SaStorage - 请求作用域：存储的数据只在一次请求内有效。
2. SaSession - 会话作用域：存储的数据在一次会话范围内有效。
3. SaApplication - 全局作用域：存储的数据在全局范围内有效。

### 作用域
1. SaStorage - 请求作用域[只在一次请求范围内有效，请求结束后数据自动清除。使用 SaStorage 时无需处于登录状态]
2. SaSession - 会话作用域[一次会话中有效，必须在登录之后使用]
3. SaApplication - 全局作用域[应用关闭后数据自动清除（如果集成了 Redis 那则是 Redis 关闭后数据自动清除）,无需登录]
如在 SaStorage 中存储的数据只在一次请求范围内有效，请求结束后数据自动清除。使用 SaStorage 时无需处于登录状态。
```java
SaStorage storage = SaHolder.getStorage();
storage.get("key");   // 取值
storage.set("key", "value");   // 写值 
storage.delete("key");   // 删值
```

## Token-Session：只有登录后才能通过 StpUtil.getTokenSession() 获取 Token-Session
```java
// 获取当前 Token 的 Token-Session 对象
StpUtil.getTokenSession();

// 获取指定 Token 的 Token-Session 对象
StpUtil.getTokenSessionByToken(token);
```