#language: nl
Functionaliteit: Tabellen

  Scenario: Tabel waarden controleren
    Gegeven de email address is gevuld met 'leah.carter@hotmail.com.bv'
    Als ik naar de table pagina ga
    Dan heeft de users tabel 3 rijen
    Dan ik 5 sekonden wacht
    En heeft de users tabel de volgende waarden:
      | id   | name             | username     | email address     |
      | '43' | 'Leah Carter'    | 'leahcarter' | de email address  |
      | '65' | 'Ethan Bell'     | 'ethanb'     | 'ebell@sa.org.bv' |
      | '16' | 'Harriet Miller' | 'harriet68'  | /hmiller@.*/      |
    En heeft de users tabel een rijen matchend met de volgende waarden:
      | name          | username     | email address     |
      | 'Ethan Bell'  | 'ethanb'     | 'ebell@sa.org.bv' |
      | 'Leah Carter' | 'leahcarter' | de email address  |
    En heeft de users tabel geen rijen mnatchend met de volgende waarden:
      | name  |
      | 'Foo' |
      | 'Bar' |

  Scenario: Lege tabel controleren
    Als ik naar de table pagina met parameters:
      | rows |
      | '0'  |
    Dan heeft de users tabel geen rijen
    En heeft de users tabel 0 rijen

  Scenario: Table row storage and matching
    Gegeven de email address is gevuld met 'leah.carter@hotmail.com.bv'
    Als ik naar de table pagina ga
    En heeft de users tabel een rijen matchend met de volgende waarden:
      | name          | username     | email address     |
      | 'Ethan Bell'  | 'ethanb'     | 'ebell@sa.org.bv' |
      | 'Leah Carter' | 'leahcarter' | de email address  |
    En (test) de 1ste users matching row variable id nested field has value '65'
    En (test) de 2de users matching row variable id nested field has value '43'
    En heeft de users tabel een rijen matchend met de volgende waarden:
      | name             | username    | email address |
      | 'Harriet Miller' | 'harriet68' | /hmiller@.*/  |
    En (test) de users matching row variable id nested field has value '16'
