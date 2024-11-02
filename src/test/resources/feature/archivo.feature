#lenguage : es
#--------------------------
Feature: Proyecto automatizacion de la pagina de la liga

  Background:
    Given usuario abre la pagina
    When usuario acepta las cookies
    Then usuario pone el raton sobre "ultmo"

  @testnumero1
  Scenario: prueba1 La liga santander
    Then usuario selecciona aleatoriamente una jornada
    And obtenemos nombres equipos y resultados
    Then escribimos en el archivo json los datos obtenidos "datosligasantander"

  @testnumero2
  Scenario: prueba2 La liga smartbank
    Then usuario selecciona aleatoriamente una jornada
    And obtenemos nombres equipos y resultados
    Then escribimos en el archivo json los datos obtenidos "datosligasmartbank"

  @testnumero3
  Scenario: prueba3 La liga femenina
    Then usuario selecciona aleatoriamente una jornada
    And obtenemos nombres equipos y resultados
    Then escribimos en el archivo json los datos obtenidos "datosfutbolfemenino"

  @testnumero4
  Scenario: prueba4 La liga Genuine Santander
    Then usuario selecciona aleatoriamente una temporada
    And usuario selecciona aleatoriamente una fase
    Then obtenemos nombres equipos y resultados divididos por mañana o tarde, sabado o domingo
    And escribimos en el archivo json los datos obtenidos sobre La Liga Genuine Santander "datosligagenuine"

  @testnumero5
  Scenario: prueba5 Tarjetas rojas
    And usuario selecciona aleatoriamente una liga
    And clica en Tarjetas rojas
    Then usuario selecciona aleatoriamente un equipo
    And recogemos los datos
    And escribimos en el archivo json los datos obtenidos sobre las tarjetas rojas "datostarjetasrojas"