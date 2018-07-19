<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkt</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Produkt</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/resource/images/${produkt.productId}.png"></c:url>" alt="image" style = "width:100%"/>
        </div>
        <div class="col-md-5">
            <h3>${produkt.name}</h3>
            <p>${produkt.description}</p>
            <p>
                <strong>Kod produktu: </strong><span class="label label-warning">${produkt.productId}</span>
            </p>
            <p>
                <strong>Producent</strong>: ${produkt.manufacturer}
            </p>
            <p>
                <strong>Kategoria</strong>: ${produkt.category}
            </p>
            <p>
                <strong>Dostępna liczba sztuk</strong>:${produkt.unitsInStock}
            </p>
            <h4>${produkt.unitPrice}PLN</h4>
            <p>
                <a href="#" class="btn btn-warning btn-large">
                    <span class="glyphicon-shopping-cart glyphicon"></span>
                    Zamów teraz
                </a>
                <a href="<spring:url value="/products" />" class="btn btndefault">
                    <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>