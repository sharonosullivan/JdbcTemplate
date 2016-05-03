<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:genericpage>
    <jsp:attribute name="header">
      <h1>Contact Manager Home</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>
        <div align="center">
            <h1>New/Edit Contact</h1>
            <form:form action="saveContact" method="post" modelAttribute="contact">
                <table>
                    <form:hidden path="id"/>
                    <tr>
                        <td>Name:</td>
                        <td><form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><form:input path="address"/></td>
                    </tr>
                    <tr>
                        <td>Telephone:</td>
                        <td><form:input path="telephone"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Save"></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </jsp:body>
</t:genericpage>
