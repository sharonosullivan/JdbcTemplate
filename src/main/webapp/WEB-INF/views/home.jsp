<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:genericpage>
    <jsp:attribute name="header">
      <h1>Contact Manager Home</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>
        <div align="center">
            <h1>Contact List</h1>
            <h3><a href="/newContact">New Contact</a></h3>
            <table border="1">
                <th>No</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Telephone</th>
                <th>Action</th>

                <c:forEach var="contact" items="${contactList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${contact.name}</td>
                        <td>${contact.email}</td>
                        <td>${contact.address}</td>
                        <td>${contact.telephone}</td>
                        <td>
                            <a href="/editContact?id=${contact.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/deleteContact?id=${contact.id}">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </jsp:body>
</t:genericpage>
