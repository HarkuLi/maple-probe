.PHONY: up
up: frontend/.env
	docker compose up -d

.PHONY: down
down:
	docker compose down

.PHONY: build
build: frontend/.env
	docker compose build

.env: .env.example
	if [ -f $@ ]; then \
		echo "\`$@\` needs to be updated according to new \`$<\`."; \
		exit 1; \
	fi
	cp $< $@

frontend/.env: .env
	cp $< $@
