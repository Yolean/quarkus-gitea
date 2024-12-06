#!/usr/bin/env bash
[ -z "$DEBUG" ] || set -x
set -eo pipefail

# https://docs.gitea.com/api/1.22/
mkdir -p runtime/src/main/openapi
curl -LS https://docs.gitea.com/redocusaurus/plugin-redoc-1.yaml \
  | sed 's/{{AppSubUrl | JSEscape}}/http:\/\/localhost/' \
  | yq -o yaml -P -I2 '
    .consumes = [.consumes[0]]
  ' \
  > runtime/src/main/openapi/gitea.yaml
