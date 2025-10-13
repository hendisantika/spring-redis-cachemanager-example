# Spring Redis CacheManager Example

A Simple Spring Boot Data Redis Cache Manager Example that demonstrates how to use Redis as a caching layer in Spring
Boot applications.

## Overview

This project showcases the integration of Spring Boot with Redis for caching purposes. It demonstrates:

- How to configure Redis connection with Jedis client
- How to set up Spring Cache with Redis backend
- Conditional caching using SpEL expressions
- Cache behavior verification

## Technologies

- Spring Boot 3.5.6
- Java 21
- Spring Data Redis
- Jedis 7.0.0
- Redis
- Maven

## Prerequisites

- Java 21 or higher
- Maven 3.x
- Redis Server running on localhost:6379

## Installation

1. Clone the repository:

```bash
git clone https://github.com/hendisantika/spring-redis-cachemanager-example.git
cd spring-redis-cachemanager-example
```

2. Ensure Redis is running:

```bash
redis-server
```

Or verify Redis is already running:

```bash
redis-cli ping
```

Expected response: `PONG`

3. Build the project:

```bash
mvn clean install
```

## Configuration

The application uses the following Redis configuration (defined in `redis.properties`):

```properties
redis.host=localhost
redis.port=6379
```

## Running the Application

Run the application using Maven:

```bash
mvn spring-boot:run
```

Or run the JAR file:

```bash
java -jar target/redis-manager-0.0.1-SNAPSHOT.jar
```

## How It Works

The application demonstrates caching with a `MusicService` that has a `play()` method:

```java

@Cacheable(value = "messageCache", condition = "'guitar'.equals(#instrument)")
public String play(final String instrument)
```

Key features:

- Only caches results when the instrument is "guitar" (conditional caching)
- The cache name is "messageCache"
- Subsequent calls with the same instrument will retrieve the result from Redis cache

### Expected Output

```
Executing: MusicService.play(trumpet)
message: paying trumpet!
Executing: MusicService.play(trumpet)
message: paying trumpet!
Executing: MusicService.play(guitar)
message: paying guitar!
message: paying guitar!
Done.
```

Notice that:

- `trumpet` executes twice (not cached due to condition)
- `guitar` executes only once; the second call retrieves from cache

## Verifying Cache

You can verify the cached data in Redis:

```bash
# Check for messageCache keys
redis-cli KEYS "*messageCache*"

# Get cached value
redis-cli GET "messageCache::guitar"
```

## Project Structure

```
src/
├── main/
│   ├── java/com/hendi/redismanager/
│   │   ├── AppConfig.java           # Redis and Cache configuration
│   │   ├── MusicService.java        # Service with cacheable method
│   │   └── RedisManagerApplication.java # Main application
│   └── resources/
│       ├── application.properties
│       └── redis.properties         # Redis connection properties
└── test/
    └── java/com/hendi/redismanager/
        └── RedisManagerApplicationTests.java
```

## Key Components

### AppConfig.java

Configures:

- Jedis connection factory
- Redis template
- RedisCacheManager using builder pattern

### MusicService.java

Service class demonstrating:

- `@Cacheable` annotation
- Conditional caching with SpEL
- Cache key generation

## Contributing

Feel free to submit issues and enhancement requests!

## Author

- Hendi Santika
- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This project is open source and available under the [MIT License](LICENSE).
