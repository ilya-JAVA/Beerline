<#import "../pager.ftl" as p>

<h2>Search</h2>
<form method="get" action="animals">
	<input type="text" name="nameFilter" value="${nameFilter!}">
	<input type="text" name="speciesFilter" value="${speciesFilter!}">
	<input type="submit" value="Search">
</form>

<h1>Our beers</h1>
<#if hasContent>
<@p.pager url page/>
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>VolumeOfBottle</th>
		<th>NumberOfBottle</th>
		<th>Description</th>
		<th>Price</th>
		<th>isDelete</th>
		<th></th>
		<th></th>
	</tr>
	<tbody>
  <#list page.content as beer>
		<tr ${beer.deleted?then('class="alert-danger"', "")}>
			<td>${beer.id}</td>
			<td>${beer.name}</td>
			<td>${beer.volumeOfBottle}</td>
			<td>${beer.numberOfBottle}</td>
			<td><#if beer.description??>${beer.description}</#if></td>
			<td>${beer.price}</td>
			<td><#if beer.deleted??>
              ${beer.deleted?then("true", "false")}
          </#if></td>
			<td><a href="/beers?editBeer=${beer.id}">edit</a></td>
			<td>${beer.deleted?then('<a href="/beers?repairId=${beer.id}">repair</a>', '<a href="/beers?removeId=${beer.id}">remove</a>')}</td>
		</tr>
  </#list>
	</tbody>
</table>
<@p.pager url page/>
<#else>
		<b>No beers!</b>
</#if>

