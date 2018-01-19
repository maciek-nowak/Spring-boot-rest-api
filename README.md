# spring-boot-project-mcnowak-codecool

## Application usecases

### Basic URL

``localhost:8080/``

User can retrieve link to this documentation by request with specific url as ``localhost:8080/``.

### Available resources:

<ol>
  <li><p>Studios</p></li>
  <li><p>Games</p></li>
</ol>

### Usecases for Studios

#### method GET

User can retrieve all <b>Studios</b> from database in *JSON* by request with specific url as ``localhost:8080/studios``.

User can retrieve <b>Studio</b> with given <b>id</b> number from database in *JSON* by request with specific url as ``localhost:8080/studios/{id}``.

#### method POST

User can add new <b>Studio</b> to database by send *HTTP request* with data provided in *JSON* type by request with specific url as ``localhost:8080/shops``.

Example *HTTP request body*:
<code>
      {
          "name": "ReallyNewer",
          "localization": "Poland",
      }
</code>

#### method PUT

User can update <b>tudio</b> with given <b>id</b> number in database by send *HTTP request* with data provided in *JSON* type by request with specific url as ``localhost:8080/studios``.

Example *HTTP request body*:

<code>
    {
        "id": 4,
        "name": "ReallyNewer",
        "localization": "Poland",
    }
</code>

#### method DELETE

User can delete <b>Studio</b> with given <b>id</b> number from database by request with specific url as ``localhost:8080/studios/{id}``.

### Usecases for Games

#### method GET

User can retrieve all <b>Games</b> from data base in *JSON* by request with specific url as ``localhost:8080/games``.

User can retrieve <b>Game</b> with given <b>id</b> number from database in *JSON* by request with specific url as ``localhost:8080/games/{id}``.


#### method POST

User can add new <b>Game</b> to database by send *HTTP request* with data provided in *JSON* type by request with specific url as ``localhost:8080/games``.

Example *HTTP request body*:
<code>
    {
        "title": "SomeFourthGame",
        "year": 1963,
        "studio": {
            "id": 3
        }
    }
</code>

#### method PUT

User can update <b>Game</b> with given <b>id</b> number in data base by send *HTTP request* with data provided in *JSON* type by request with specific url as ``localhost:8080/games``.

Example *HTTP request body*:

<code>
    {
        "id": 5,
        "title": "SomeFourthGame",
        "year": 1963,
        "studio": {
            "id": 3
        }
    }
</code>

#### method DELETE

User can delete <b>Game</b> with given <b>id</b> number from database by request with specific url as ``localhost:8080/games/{id}``.