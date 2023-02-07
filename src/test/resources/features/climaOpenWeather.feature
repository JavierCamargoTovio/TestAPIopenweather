@Api
Feature: Consultar el estado del clima en tiempo real por la api OpenWeather

  Scenario Outline: Consultar el estado del clima en OpenWeather
    Given que un usuario quiere consumir el servicio OpenWeather
    When envia la peticion por el metodo GET con "<idCiudad>"  correcto
    Then el deberia visualizar "<idCiudad>" que sea igual al enviado
    Examples:
      | idCiudad |
      | 3674962 |