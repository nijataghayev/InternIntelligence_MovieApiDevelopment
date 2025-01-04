# InternIntelligence_MovieAPI

This project is an API service that manages movie and genre information for users. The system allows operations such as adding movies, managing genres, and user registration, retrieval, updating, and deletion.

## Endpoints

### 🎬 FilmController

- POST /films - Add a new movie.
This method is used to add a new movie. The movie is added to the system by sending a FilmDto object.

- GET /films/genre/{genreId} - Get movies by genre.
Gets all the movies related to a given genre. It is possible to retrieve movies matching the genreId.

- GET /films/title/{title} - Find movie by title.
Finds a movie matching the given title. If no movie is found by the title, an exception is thrown.

### 🎵 GenreController

- POST /genres - Add a new genre.
This method is used to add a new genre. A new genre is added to the system by sending a GenreDto object.

- GET /genres - Get all genres.
Retrieves all genres in the system and returns them in GenreDto format.

### 👤 UserController

- POST /users - User registration.
This method is used for new user registration. The user registration is performed by sending a UserDto object.

- GET /users/username/{username} - Find user by username.
Finds a user by the given username. If the user is found, their data is returned in UserDto format, otherwise, an exception is thrown.

- PUT /users/{userId} - Update user information.
Updates the information of a user with the given userId. UserDto data is received and replaces the user's information.

- DELETE /users/{userId} - Delete a user.
Deletes a user with the given userId from the system. An exception is thrown if the user is not found.

## Services

### 🎬 FilmService

- addFilm(FilmDto filmDto): Adds a new movie.
- getFilmsByGenre(Long genreId): Retrieves all movies for the given genre.
- findByTitle(String title): Finds a movie by title.

### 🎵 GenreService

- addGenre(GenreDto genreDto): Adds a new genre.
- getAllGenres(): Retrieves all genres.

### 👤 UserService

- registerUser(UserDto userDto): Registers a new user.
- findUserByUsername(String username): Finds a user by username.
- updateUser(Long userId, UserDto userDto): Updates user information.
- deleteUser(Long userId): Deletes a user from the system.

## Tests

### 🎬 FilmServiceTest

- AddFilm- This test checks the operation of adding a new movie. It tests the conversion of a FilmDto object to FilmEntity and the execution of the filmRepository.save() method.

- GetFilmsByGenre- This test verifies that the films are correctly retrieved by the given genre. It ensures the proper operation of filmRepository.findByGenreId() and filmMapper.mapToDtos() methods.

- FindByTitle- This test checks the retrieval of a movie based on the given title. It verifies the functionality of filmRepository.findByTitle() and filmMapper.mapToDto() methods.

- FindByTitle throws RuntimeException when film not found- This test ensures that a RuntimeException is thrown when no movie is found for the given title.

### 🎵 GenreServiceTest

- AddGenre- This test checks the addition of a new genre. It verifies the functionality of genreMapper.mapToEntity() and genreRepository.save() methods.

- GetAllGenres- This test ensures that all genres in the system are correctly retrieved. It checks the operation of genreRepository.findAll() and genreMapper.mapToDto() methods.

### 👤 UserServiceTest

- RegisterUser- This test checks the user registration process. It ensures the proper operation of userMapper.mapToEntity() and userRepository.save() methods.

- FindUserByUsername- This test ensures the correct retrieval of a user by the given username. It checks the operation of userRepository.findByUsername() and userMapper.mapToDto() methods.

- FindUserByUsername throws RuntimeException when user not found- This test verifies that a RuntimeException is thrown when no user is found for the given username.

- UpdateUser- This test checks that the user data is correctly updated based on the provided userId. It ensures the proper operation of userRepository.findById() and userMapper.mapToEntity() methods.

- DeleteUser- This test verifies that a user is correctly deleted. It ensures the proper functionality of userRepository.findById() and userRepository.delete() methods.

## Installation and Usage

To install the project locally, follow these steps:

```bash
git clone https://github.com/nijataghayev/InternIntelligence_MovieApiDevelopment
cd InternIntelligence_MovieApiDevelopment
gradle build
java -jar build/libs/InternIntelligence_MovieApiDevelopment.jar
