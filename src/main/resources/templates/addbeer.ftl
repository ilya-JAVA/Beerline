<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
  <h2>Add beer for ${user.firstName} ${user.surname} ${user.lastName}</h2>
  <form method="post">
      <#if beerError?? && beerError?has_content><div style="color:red">${beerError}</div></#if>
    <input type="hidden" name="id"
           value="<#if beer?? && beer.id??>${beer.id}</#if>"/>
    <input type="text" name="name" placeholder="Name"
           class="form-control ${(nameError??)?string('is-invalid', '')}"
           value="<#if beer?? && beer.name??>${beer.name}</#if>"/>
    <input type="text" name="volumeOfBottle" placeholder="VolumeOfBottle"
           class="form-control ${(volumeOfBottleError??)?string('is-invalid', '')}"
           value="<#if beer?? && beer.volumeOfBottle??>${beer.volumeOfBottle}</#if>"/>
    <input type="text" name="numberOfBottle" placeholder="NumberOfBottle"
           class="form-control ${(numberOfBottleError??)?string('is-invalid', '')}"
           value="<#if beer?? && beer.numberOfBottle??>${beer.numberOfBottle}</#if>"/>
    <input type="text" name="description" placeholder="Description"
           class="form-control ${(descriptionError??)?string('is-invalid', '')}"
           value="<#if beer?? && beer.descriptione??>${beer.description}</#if>"/>
    <input type="text" name="price" placeholder="Price"
           class="form-control ${(priceError??)?string('is-invalid', '')}"
           value="<#if beer?? && beer.price??>${beer.price}</#if>"/>
<#--    private Double volumeOfBottle;-->

<#--    @NonNull-->
<#--    private Integer numberOfBottle;-->

<#--    @NotBlank-->
<#--    private String description;-->

<#--    @NonNull-->
<#--    private BigDecimal price;-->
    <button type="submit" style="color: black"><#if beer??>Edit<#else>Add</#if></button>
  </form>
  <h2>User beers</h2>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>VolumeOfBottle<th>
      <th>NumberOfBottle<th>
      <th>Description<th>
      <th>Price</th>
      <th>isDelete</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
    <tbody>
    <#list beers as beer>
      <tr ${beer.deleted?then('class="alert-danger"', "")}>
        <td>${beer.id}</td>
        <td>${beer.name}</td>
        <td>${beer.volumeOfBottle}</td>
        <td>${beer.numberOfBottle}</td>
        <td>${beer.description}</td>
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
</@pt.page>