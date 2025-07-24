#!/bin/bash

BOLD="\033[1m"
GREEN="\033[0;32m"
YELLOW="\033[0;33m"
CYAN="\033[0;36m"
NC="\033[0m"

echo ""
echo -e "${BOLD}${GREEN}🚀 Bem-vindo ao Ambiente de Desenvolvimento pedido!${NC}"
echo -e "${CYAN}---------------------------------------------------------------------------------------------${NC}"
echo "Abaixo estão os serviços disponíveis e suas URLs de acesso:"
echo ""

printf "┌%-25s┬%-12s┬%-53s┐\n" "─────────────────────────" "────────────" "─────────────────────────────────────────────────────"

printf "| ${BOLD}%-23s ${NC} | ${BOLD}%-10s ${NC}| ${BOLD}%-51s ${NC}  |\n" "SERVIÇO" "PORTA" "URL DE ACESSO / DESCRIÇÃO"

printf "├%-25s┼%-12s┼%-53s┤\n" "─────────────────────────" "────────────" "─────────────────────────────────────────────────────"

while IFS=, read -r icon service port url; do
    printf "| ${CYAN}%-2s %-20s${NC} | ${YELLOW}%-10s${NC} | %-51s |\n" "$icon" "$service" "$port" "$url"
done << EOF
🖥️,pedido-service,8081,http://localhost:8081/api/v1/swagger-ui/index.html
🛢️,postgres,5432,Acesso via DBeaver ou psql
📈,postgres-exporter,9187,http://localhost:9187/metrics
🔐,keycloak,8080,http://localhost:8080 (admin/admin)
🏢,kong-admin,8001,http://localhost:8001
➡️,kong-proxy,8000,Ponto de entrada principal da API
📊,prometheus,9090,http://localhost:9090
🎨,grafana,3000,http://localhost:3000 (admin/admin)
📜,loki,3100,Acessado via Grafana (datasource)
🛰️,otel-collector(gRPC),4317,N/A (serviço interno)
🛰️,otel-collector(HTTP),4318,N/A (serviço interno)
EOF

printf "└%-25s┴%-12s┴%-53s┘\n" "─────────────────────────" "────────────" "─────────────────────────────────────────────────────"

echo ""
echo -e "💡 ${BOLD}Dica:${NC}  Use o Grafana para visualizar métricas e logs centralizados."
echo ""

