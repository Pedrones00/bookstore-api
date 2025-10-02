# Running PostgreSQL in Docker
---

```bash
docker run --name my-postgres \
  -e POSTGRES_USER=myuser \
  -e POSTGRES_PASSWORD=secretpassword \
  -e POSTGRES_DB=mydb_name \
  -p 5555:5432 \
  -d postgres:16
```