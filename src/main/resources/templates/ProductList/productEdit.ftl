<#import "../parts/common.ftl" as c>
<@c.page>
Product editor
    ${message?ifExists}
<form action="/product/edit/" method="post">
    <input type="text" name="productname" value="${product.productname}">
    <input type="number" name="productcost" step="0.01" value="${product.productcost}">
    <input type="number" name="productamount" value="${product.productamount}">
    <input type="hidden" value="${product.productid}" name="productId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
</@c.page>