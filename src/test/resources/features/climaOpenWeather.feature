@Api
Feature: Consultar el estado del clima en tiempo real por la api OpenWeather

  Scenario: Consultar el estado del clima en OpenWeather
    Given que un usuario quiere consumir el servicio OpenWeather
    When envia la peticion por el metodo GET con "3674962" correcto
    Then el deberia visualizar idciudad que sea igual al enviado