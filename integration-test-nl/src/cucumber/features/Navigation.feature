#language: nl
Functionaliteit: Pagina navigatie functionaliteit

  Scenario: Basic pagina scenario
    Als ik naar de home pagina ga
    Dan ben ik op de home pagina

  Scenario: Directe redirect
    Als ik via de instant redirect pagina ga
    Dan ben ik op de second pagina

  Scenario: Vertraagde redirect
    Als ik naar de delayed redirect pagina ga
    Dan ben ik op de delayed redirect pagina
    Als ik 2 sekonden wacht
    Dan ben ik op de second pagina

  Scenario: Vertraagde redirect met uiteindelijk
    Als ik naar de delayed redirect pagina ga
    Dan ben ik uiteindelijk op de second pagina

  Scenario: Directe URL
    Als ik ga naar 'http://localhost:8080/integration-test-nl/form.jsp'
    Dan ben ik op de form pagina

  Scenario: Directe URI
    Als ik ga naar 'form.jsp'
    Dan ben ik op de form pagina

  Scenario: URL Test
    Als ik naar de form pagina ga
    Dan ben ik op 'http://localhost:8080/integration-test-nl/form.jsp'
    Dan ben ik op 'form.jsp'

  Scenario: Pagina met parameters
    Gegeven de hondennaam is gevuld met 'Max'
    Als ik naar de form pagina met parameters:
      | greeting   | dogName       |
      | 'hi there' | de hondennaam |
    Dan ben ik op 'form.jsp?greeting=hi+there&dogName=Max'

  Scenario: Redirect met parameters
    Gegeven de hondennaam is gevuld met 'Max'
    Als ik via de instant redirect pagina met parameters ga:
      | greeting   | dogName       |
      | 'hi there' | de hondennaam |
    Dan ben ik op 'page2.jsp?greeting=hi+there&dogName=Max'

  Scenario: Vertraagde redirect with parameters
    Gegeven de hondennaam is gevuld met 'Max'
    Als ik via de delayed redirect pagina met parameters ga:
      | greeting   | dogName       |
      | 'hi there' | de hondennaam |
    Dan ben ik uiteindelijk op 'page2.jsp?greeting=hi+there&dogName=Max'

  Scenario: Pagina met een enkele variabele naam
    Gegeven de dog id is gevuld met '1'
    Als ik naar de form pagina ga voor de dog id
    Dan ben ik op 'form.jsp?dog_id=1'

  Scenario: Pagina met expliciete parameter
    Als ik naar de form pagina ga voor dog id van '1'
    Dan ben ik op 'form.jsp?dog_id=1'

  Scenario: Redirect met een enkele variable name
  Gegeven de dog id is gevuld met '1'
    Als ik via de instant redirect pagina ga voor de dog id
    Dan ben ik op 'page2.jsp?dog_id=1'

  Scenario: Redirect met expliciete parameter
    Als ik naar de instant redirect pagina ga voor dog id van '1'
    Dan ben ik op 'page2.jsp?dog_id=1'
