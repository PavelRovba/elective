<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>

<h2>Dear Student, Please enter your details</h2>
<br>
<br>


<c:form action="showDetails" modelAttribute="student" method="get">
    Name <c:input path="name"/>
    <c:errors path="name"/>
    <br>
    <br>
    Surname <c:input path="surname"/>
    <c:errors path="surname"/>
    <br>
    <br>
    Salary <c:input path="salary"/>
    <c:errors path="salary"/>
    <br>
    <br>
    Department <c:select path="department">
    <c:options items="${employee.departments}"/>
</c:select>
    <br>
    <br>
    Which car do you want?
    <c:radiobuttons path="carBrand" items="${employee.carBrands}"/>
    <br>
    <br>
    Foreign language(s)
    <c:checkboxes path="languages" items="${employee.languageList}"/>
    <br>
    <br>
    Phone number: <c:input path="phoneNumber"/>
    <c:errors path="phoneNumber"/>
    <br>
    <br>
    Email: <c:input path="email"/>
    <c:errors path="phoneNumber"/>
    <br>
    <br>
    <input type="submit" value="OK">
</c:form>

</body>

</html>