<#import "../parts/common.ftl" as c>
<@c.page>
Shop editor
    ${message?ifExists}
<form action="/shop/edit/" method="post">
    <input type="text" name="shopname" value="${shop.shopname}">
    <input type="hidden" value="${shop.id}" name="shopId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
</@c.page>