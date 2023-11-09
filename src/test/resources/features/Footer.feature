Feature: Footer Feature

  @GetPaymentFooter
  Scenario: getPaymentFooter - validate json schema
    Given [Footer] send "GET" request to "https://www.blibli.com/backend/common/payments/_active/web-footer"
    Then [Footer] validate json schema by "jsonSchema/GetPaymentFooter.json"
