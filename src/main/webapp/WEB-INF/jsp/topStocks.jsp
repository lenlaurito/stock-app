<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title></title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script src="mainApp.js"></script>
<script src="stockController.js"></script>
<style>
table, th , td {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f2f2f2;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>
</head>
<body>
    <c:if test = "${currentUser == null}">
        <a href="/login">Login</a>
    </c:if>
    <c:if test = "${currentUser != null}" >
        Hello ${currentUser.getUsername()}!
        <form action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Log out</button>
        </form>
    </c:if>

    <h2>Top Stocks</h2>
    <div ng-app="stockApp" ng-init="topStockList=getTopStocks()" ng-controller="stockController">
        <table>
           <tr>
              <th>Company Name</th>
              <th>Price</th>
           </tr>
           <tr ng-repeat="topStock in topStockList">
              <td>{{topStock.companyName}}</td>
              <td>{{topStock.price}}</td>
           </tr>
        </table>
        </td></tr>
        </table>
    </div>
</body>
</html>