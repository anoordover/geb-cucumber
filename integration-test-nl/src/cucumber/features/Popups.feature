#language: nl
Functionaliteit: Popups

  Scenario: Popup windows kunnen worden gesloten zonder naar ze over te schakelen
    Als ik naar de home pagina ga
    En ik klik op de popup button
    Dan verschijnt een popup window
    Als ik het popup window sluit
    Dan ben ik op de home pagina

  Scenario: Popup windows kunnen worden gesloten na er naar toe te zijn gegaan
    Als ik naar de home pagina ga
    En ik klik op de popup button
    Dan verschijnt een popup window
    Als ik overschakel naar het popup window
    En ik het popup window sluit
    Dan ben ik op de home pagina

  Scenario: Popup windows kunnen worden gesloten met interactie
    Als ik naar de home pagina ga
    En ik klik op de popup button
    Dan verschijnt de second pagina popup
    Als ik klik op de close button
    Dan sluit het popup window
    Dan ben ik op de home pagina

  Scenario: Alert box kan worden geaccepteerd
    Als ik naar de home pagina ga
    En ik klik op de alert button
    Dan verschijnt een alert box met de melding 'Click OK'
    Als ik de alert box accepteer
    Dan ben ik op de home pagina

  Scenario: Alert box kan worden geaccepteerd zonder de melding te controleren
    Als ik naar de home pagina ga
    En ik klik op de alert button
    Dan verschijnt een alert box
    Als ik de alert box accepteer
    Dan ben ik op de home pagina

  Scenario: Confirm box kan worden geaccepteerd
    Als ik naar de home pagina ga
    En ik klik op de confirm button
    Dan verschijnt een alert box met de melding 'Click OK or Cancel'
    Als ik de alert box accepteer
    Dan ben ik op de home pagina
    En heeft de alert result de waarde 'true'

  Scenario: Confirm box kan worden geannuleerd
    Als ik naar de home pagina ga
    En ik klik op de confirm button
    Dan verschijnt een alert box met de melding 'Click OK or Cancel'
    Als ik de alert box annuleer
    Dan ben ik op de home pagina
    En heeft de alert result de waarde 'false'

  Scenario: Prompt box kan worden geaccepteerd
    Als ik naar de home pagina ga
    En ik klik op de prompt button
    Dan verschijnt een alert box met de melding 'Type something'
    Als ik in de alter box 'ok' type
    En ik de alert box accepteer
    Dan ben ik op de home pagina
    En heeft de alert result de waarde 'ok'

  Scenario: Prompt box can be dismissed
    Als ik naar de home pagina ga
    En ik klik op de prompt button
    Dan verschijnt een alert box met de melding 'Type something'
    Als ik in de alter box 'ok' type
    En ik de alert box annuleer
    Dan ben ik op de home pagina
    En heeft de alert result de waarde ''
