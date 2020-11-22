<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)


<!-- ABOUT THE PROJECT -->
## About The Project

A command line tool in Java that optimises what items can get into a delivery package so that the total value of the package is the biggest.

<!-- GETTING STARTED -->
## Getting Started

To run this program or contribute follow the steps bellow.

## Prerequisites

* Java 8
* Maven (if you want to build it yourself)

## Installation

####1. Use already built `.jar`:
- go to this repo's Releases page and download the latest `.jar` file
- run the `.jar` like this (needs `Java 8` installed, change the jar name as needed):
   ```
  java -jar delivery-package-optimizer-1.0.jar "file-to-read-from.txt"
   ```

####2. Build it yourself:
Clone the repo
```
git clone https://github.com/bogdanguranda/delivery-package-optimizer.git
```
Build with Maven (needs Maven installed on your machine)
```
mvn package
```
Run the `.jar`
```
java -jar target/delivery-package-optimizer-1.0.jar "file-to-read-from.txt"
```


<!-- USAGE EXAMPLES -->
## Usage

To understand the format of the file that is needed, check the sample under `src/test/resources/rightFormatFile.txt`

<!-- CONTRIBUTING -->
## Contributing

Any contributions are much **appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/my-amazing-feature`)
3. Commit your Changes (`git commit -m "Added some amazing feature"`)
4. Push to the Branch (`git push origin feature/my-amazing-feature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the GNU General Public License v3.0. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Bogdan Guranda - [LinkedIn](https://www.linkedin.com/in/bogdan-guranda/) - bogdanguranda@gmail.com
