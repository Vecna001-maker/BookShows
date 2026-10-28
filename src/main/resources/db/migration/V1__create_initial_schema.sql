CREATE TABLE users (
    user_id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_name       VARCHAR(256) NOT NULL,
    user_email      VARCHAR(256) NOT NULL,
    user_password   VARCHAR(256) NOT NULL,
    user_role       VARCHAR(10) NOT NULL,
    created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE events (
    event_id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_title         VARCHAR(256) NOT NULL,
    event_description   VARCHAR(256) NOT NULL,
    attachment_url      VARCHAR(256) NOT NULL,
    user_id             UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE comments (
    comment_id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    comment_description     VARCHAR(256) NOT NULL,
    user_id                 UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    event_id                UUID NOT NULL REFERENCES events(event_id) ON DELETE CASCADE,
    parent_comment_id       UUID DEFAULT NULL,
    created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE user_preferences (
    preference_id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    preference_status   BOOLEAN NOT NULL,
    event_id            UUID NOT NULL REFERENCES events(event_id) ON DELETE CASCADE,
    user_id             UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
    created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);