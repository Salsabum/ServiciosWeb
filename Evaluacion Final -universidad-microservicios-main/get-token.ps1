param(
    [string]$Realm = "universidad",
    [string]$ClientId = "swagger-client",
    [string]$Username = "alumno1",
    [string]$Password = "123456",
    [string]$KeycloakBaseUrl = "http://localhost:9090"
)

$tokenEndpoint = "$KeycloakBaseUrl/realms/$Realm/protocol/openid-connect/token"
$body = "grant_type=password&client_id=$ClientId&username=$Username&password=$Password"

try {
    $response = Invoke-RestMethod -Method Post -Uri $tokenEndpoint -ContentType "application/x-www-form-urlencoded" -Body $body
    Write-Output "Bearer $($response.access_token)"
} catch {
    Write-Error "No se pudo generar el token. Verifica Keycloak, realm, client_id y credenciales."
    Write-Error $_
}
