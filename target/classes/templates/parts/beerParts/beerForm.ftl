<h2>Search</h2>
<form method="get" action="beers">
	<input type="text" name="nameFilter" placeholder="Name" value="${nameFilter!}">
	<input type="text">
	<input type="submit" value="Search">
</form>

<h2>Add beer</h2>
<form method="post">
    <#if beerError?? && beerError?has_content><div style="color:red">${beerError}</div></#if>
<input type="hidden" name="id"
       value="<#if beer?? && beer.id??>${beer.id}</#if>"/>
<input type="text" name="name" placeholder="Name"
       class="form-control ${(nameError??)?string('is-invalid', '')}"
       value="<#if beer?? && beer.name??>${beer.name}</#if>"/>
<input type="text" name="volumeOfBoottle" placeholder="volumeOfBottle"
       class="form-control ${(speciesError??)?string('is-invalid', '')}"
       value="<#if beer?? && beer.volumeOfBottle??>${beer.volumeOfBottle}</#if>" />
<input type="text" name="numberOfBottle" placeholder="numberOfBottle"
       class="form-control ${(sexError??)?string('is-invalid', '')}"
       value="<#if beer?? && beer.numberOfBottle??>${beer.numberOfBottle}</#if>" />
<input type="date" name="description"
       class="form-control ${(birthError??)?string('is-invalid', '')}"
       value="<#if beer?? && beer.description??>${beer.description}</#if>">
	<input type="text" name="price" placeholder="price"
		   class="form-control ${(beerError??)?string('is-invalid', '')}"
		   value="<#if beer?? && beer.price??>${beer.price}</#if>" />
<button type="submit" style="color: #000000"><#if beer??>Edit<#else>Add</#if></button>
</form>
<#--<th>ID</th>-->
<#--<th>Name</th>-->
<#--<th>VolumeOfBottle<th>-->
<#--<th>NumberOfBottle<th>-->
<#--<th>Description<th>-->
<#--<th>Price</th>-->
<#--<th>isDelete</th>-->