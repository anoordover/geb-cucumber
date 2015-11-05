#language: nl
Functionaliteit: : Interaction features

  Scenario: Waarden 1 voor 1 invullen
    Als ik naar de form pagina ga
    Dan heeft het name veld de waarde van "Ada Lovelace"
    En heeft het favourite language veld de waarde ''
    En is de use gnat checkbox niet aangevinkt
    Als ik 'foo' in het name veld type
    En ik 'Ada95' in het favourite language veld selecteer
    En ik klik op de use gnat checkbox
    Dan heeft het name veld de waarde van 'foo'
    En heeft het favourite language veld de waarde 'Ada95'
    En is de use gnat checkbox aangevinkt

  Scenario: Waarden invullen met de tabel syntax
    Als ik naar de form pagina ga
    En ik type de volgende waarden:
      | name           | favourite language | use gnat   |
      | 'Ada Lovelace' | 'Ada95'            | aangevinkt |
    Dan heeft het name veld de waarde van 'Ada Lovelace'
    En heeft het favourite language veld de waarde 'Ada95'
    En is de use gnat checkbox aangevinkt
    Als ik type de volgende waarden:
      | name           | favourite language | use gnat        |
      | 'Donald Knuth' | 'Tex'              | niet aangevinkt |
    Dan heeft de pagina de volgende waarden:
      | name           | favourite language | use gnat        |
      | 'Donald Knuth' | 'Tex'              | niet aangevinkt |

  Scenario: Waarden invullen in de module velden met de tabel syntax
    Als ik naar de form pagina ga
    En ik type de volgende waarden in de address sectie:
      | street address                 | city      | state | postcode | registered mail only |
      | 'Norwood Oval\n4 Woods Street' | 'Norwood' | 'SA'  | '5067'   | niet aangevinkt      |
    Dan heeft het address sectie street address veld de waarde van 'Norwood Oval\n4 Woods Street'
    Dan heeft het address sectie city veld de waarde van 'Norwood'
    Dan heeft het address sectie state veld de waarde van 'SA'
    Dan matcht het address sectie postcode veld de waarde /\d{4}/
    Dan is de address sectie registered mail only checkbox niet aangevinkt
    Als ik type de volgende waarden in de address sectie:
      | street address     | city        | state | postcode | registered mail only |
      | '39 George Street' | 'Thebarton' | 'SA'  | '5031'   | aangevinkt           |
    Dan heeft de address sectie de volgende waarden:
      | street address     | city        | state | postcode | registered mail only |
      | '39 George Street' | 'Thebarton' | 'SA'  | /\d{4}/  | aangevinkt           |

  Scenario: Controleren van generieke inhoud
    Als ik naar de home pagina met parameters:
      | greeting   |
      | 'hi there' |
    Dan is het greeting veld aanwezig
    En is het greeting veld zichtbaar
    En heeft de greeting de waarde van 'hi there'
    En heeft het greeting veld de waarde van 'hi there'
    En heeft het greeting label de waarde van 'hi there'

  Scenario: Controleren op afwezigheid van elementen
    Als ik naar de home pagina ga
    Dan is het greeting veld afwezig

  Scenario: Verborgen content
    Als ik naar de home pagina met parameters:
      | greeting   | greetingHidden |
      | 'hi there' | 'true'         |
    Dan is het greeting veld aanwezig
    En is de greeting onzichtbaar

  Scenario: Waarden in pagina uit een map-variabele met tabel syntax
    Gegeven the programmer map variable has the following values:
      | full name    | lang    |
      | 'Bill Gates' | 'Basic' |
    Als ik naar de form pagina ga
    Als ik type de volgende waarden uit de programmer:
      | name      | favourite language |
      | full name | lang               |
    Dan heeft het name veld de waarde van 'Bill Gates'
    Dan heeft het favourite language veld de waarde van 'Basic'
    En heeft de pagina de volgende waarden uit de programmer:
      | name      | favourite language |
      | full name | lang               |

  Scenario: Waarden in module velden uit een map-variabele met tabel syntax
    Gegeven the foo address map variable has the following values:
      | address lines                  | suburb    | state | zip    |
      | 'Norwood Oval\n4 Woods Street' | 'Norwood' | 'SA'  | '5067' |
    Als ik naar de form pagina ga
    En ik type de volgende waarden in de address sectie uit de foo address:
      | street address | city   | state | postcode |
      | address lines  | suburb | state | zip      |
    Dan heeft het address sectie street address veld de waarde van 'Norwood Oval\n4 Woods Street'
    En heeft het address sectie city veld de waarde van 'Norwood'
    En heeft het address sectie state veld de waarde van 'SA'
    En matcht het address sectie postcode veld de waarde van /\d{4}/
    En heeft de address sectie de volgende waarden uit de foo address:
      | street address | city   | state | postcode |
      | address lines  | suburb | state | zip      |
