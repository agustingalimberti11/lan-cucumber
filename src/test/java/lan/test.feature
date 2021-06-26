Feature: comprar un ticket

  @Prueba1
  Scenario: voy a comprar un producto y escoger un medio de pago.
    Given : como cliente ingreso a la URL "https://www.latam.com/es_ar/"
    When : selecciono un destino.
    And : Lo agrego a la bolsa.
    Then : escojo un medio de pago.

