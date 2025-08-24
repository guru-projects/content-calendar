# Content Calendar API

A Spring Boot RESTful API for managing content calendar with different content types, statuses, and scheduling capabilities.

## 📋 Features

- **Content Management**: Create, read, update, and delete content items
- **Content Types**: Support for articles, videos, courses, and conference talks
- **Status Tracking**: Track content through different stages (IDEA, IN_PROGRESS, COMPLETED, PUBLISHED)
- **Filtering**: Filter content by type
- **PostgreSQL Integration**: Persistent data storage with PostgreSQL
- **Data Initialization**: Automatic data loading from JSON files
- **Validation**: Input validation for content creation and updates
- **RESTful API**: Clean REST endpoints with proper HTTP status codes

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JDBC**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Jackson** (JSON processing)
- **Maven** (Build tool)

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/com/guru/content_calendar/
│   │   ├── Application.java                 # Main application class
│   │   ├── config/
│   │   │   ├── ContentCalenderProperties.java # Configuration properties
│   │   │   └── DataLoader.java              # Database initialization
│   │   ├── controller/
│   │   │   ├── ContentController.java       # REST API endpoints
│   │   │   └── HomeController.java          # Home endpoint
│   │   ├── model/
│   │   │   ├── Content.java                 # Content entity
│   │   │   ├── Status.java                  # Status enum
│   │   │   └── Type.java                    # Content type enum
│   │   └── repository/
│   │       ├── ContentRepository.java       # Database operations
│   │       └── ContentCollectionRepository.java # In-memory operations
│   └── resources/
│       ├── data/
│       │   └── content.json                 # Sample data
│       ├── schema.sql                       # Database schema
│       └── application.properties           # Configuration
├── docker-compose.yml                       # PostgreSQL setup
└── pom.xml                                  # Maven dependencies
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Docker and Docker Compose

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/content-calendar.git
   cd content-calendar
   ```

2. **Start PostgreSQL with Docker**
   ```bash
   docker-compose up -d
   ```

3. **Create the database table**
   ```bash
   docker exec -it content-calendar-db-1 psql -U postgres -d postgres -c "
   CREATE TABLE IF NOT EXISTS content (
       id SERIAL PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       description TEXT,
       status VARCHAR(50),
       content_type VARCHAR(50),
       date_created TIMESTAMP,
       date_updated TIMESTAMP,
       url VARCHAR(500)
   );"
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Content Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/content` | Get all content items |
| `GET` | `/api/content/{id}` | Get content by ID |
| `POST` | `/api/content` | Create new content |
| `PUT` | `/api/content/{id}` | Update existing content |
| `DELETE` | `/api/content/{id}` | Delete content |
| `GET` | `/api/content/filter/type/{type}` | Filter content by type |

### Other Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/` | Home endpoint with welcome message |

## 📝 API Usage Examples

### Get all content
```bash
curl http://localhost:8080/api/content
```

### Create new content
```bash
curl -X POST http://localhost:8080/api/content \
  -H "Content-Type: application/json" \
  -d '{
    "title": "My New Blog Post",
    "description": "This is a comprehensive guide to Spring Boot",
    "status": "IDEA",
    "contentType": "ARTICLE",
    "url": "https://example.com/blog-post"
  }'
```

### Update content
```bash
curl -X PUT http://localhost:8080/api/content/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated Blog Post",
    "description": "Updated description",
    "status": "PUBLISHED",
    "contentType": "ARTICLE",
    "url": "https://example.com/updated-post"
  }'
```

### Filter by content type
```bash
curl http://localhost:8080/api/content/filter/type/ARTICLE
```

## 🏷️ Data Models

### Content
```json
{
  "id": 1,
  "title": "Content Title",
  "description": "Content description",
  "status": "PUBLISHED",
  "contentType": "ARTICLE",
  "dateCreated": "2024-01-01T10:00:00",
  "dateUpdated": "2024-01-02T15:30:00",
  "url": "https://example.com/content"
}
```

### Status Enum
- `IDEA` - Initial concept
- `IN_PROGRESS` - Currently being worked on
- `COMPLETED` - Finished but not published
- `PUBLISHED` - Live and available

### Content Type Enum
- `ARTICLE` - Blog posts, articles
- `VIDEO` - Video content
- `COURSE` - Educational courses
- `CONFERENCE_TALK` - Presentation content

## ⚙️ Configuration

### Database Configuration
```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/postgres
spring.datasource.username=postgres
spring.datasource.password=password
```

### Custom Properties
```properties
cc.welcomeMessage=Welcome to Content Calendar
cc.about=About
```

## 🐳 Docker Setup

The project includes a `docker-compose.yml` file for PostgreSQL:

```yaml
version: '3.8'
services:
  db:
    image: postgres:alpine
    ports:
      - "5433:5432"
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
      POSTGRES_DB: postgres
```

## 🧪 Testing

### Manual Testing
1. Start the application
2. Use curl commands or Postman to test endpoints
3. Check the database for data persistence

### Sample Data
The application automatically loads sample data from `src/main/resources/data/content.json` on startup if the database is empty.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔧 Troubleshooting

### Common Issues

1. **Database connection errors**
   - Ensure Docker container is running: `docker ps`
   - Check if PostgreSQL is accessible: `docker logs content-calendar-db-1`

2. **Table doesn't exist errors**
   - Create table manually using the provided SQL command
   - Ensure `schema.sql` is in the correct location

3. **Port conflicts**
   - Change the port in `docker-compose.yml` if 5433 is in use
   - Update `application.properties` accordingly

## 📞 Support

If you have any questions or issues, please create an issue in the GitHub repository.

---

**Happy coding! 🚀**
