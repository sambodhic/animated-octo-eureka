# animated-octo-eureka
Spring boot SOAP, REST & GraphQL

wsdl : http://localhost:8080/animated/octo/eureka/ws/demo.wsdl  
rs: http://localhost:8080/greeting  
graphql: http://localhost:8080/graphiql  

```
query findOne($id:ID!){
  findOne(id:$id) {
    title
    pages
  }
}

{
  "id": 1
}