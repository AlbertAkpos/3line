package me.alberto.a3line.mockdata

import me.alberto.a3line.data.remote.model.AddressDTO
import me.alberto.a3line.data.remote.model.CompanyDTO
import me.alberto.a3line.data.remote.model.GeoDTO
import me.alberto.a3line.data.remote.model.UserDTO

val remoteResponse = arrayListOf(
    UserDTO(
        id = 1,
        name = "Leanne Graham",
        username = "Bret",
        email = "Sincere@ april.biz",
        address = AddressDTO(
            street = "Kulas Light",
            suite = "Apt.556",
            city = "Gwenborough",
            zipcode = "92998 - 3874",
            geo = GeoDTO(lat = " -37.3159", lng = "81.1496")
        ),
        phone = " 1 - 770 - 736 - 8031",
        website = "hildegard.org",
        company = CompanyDTO(
            name = " Romaguera Crona",
            catchPhrase = "Multi - layered client -server neural -net",
            bs = "harness real -time e -markets"
        )
    ),
    UserDTO(
        id = 2,
        name = "Ervin Howell",
        username = "Antonette",
        email = "Shanna@ melissa.tv",
        address = AddressDTO(
            street = "Victor Plains",
            suite = "Suite 879",
            city = "Wisokyburgh",
            zipcode = "90566 - 7771",
            geo = GeoDTO(lat = "-43.9509", lng = "-34.4618")
        ),
        phone = "010 - 692 - 6593",
        website = "anastasia.net",
        company = CompanyDTO(
            name = "Deckow - Crist",
            catchPhrase = "Proactive didactic contingency",
            bs = "synergize scalable supply - chains"
        )
    ),
    UserDTO(
        id = 3,
        name = "Clementine Bauch",
        username = "Samantha",
        email = "Nathan@ yesenia.net",
        address = AddressDTO(
            street = "Douglas Extension",
            suite = "Suite 847",
            city = "McKenziehaven",
            zipcode = "59590 - 4157",
            geo = GeoDTO(lat = "-68.6102", lng = "-47.0653")
        ),
        phone = "1 - 463 - 123 - 4447",
        website = "ramiro.info",
        company = CompanyDTO(
            name = "Romaguera - Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e -enable strategic applications"
        )
    ),
    UserDTO(
        id = 4,
        name = "Patricia Lebsack",
        username = "Karianne",
        email = "Julianne.OConner@kory.org",
        address = AddressDTO(
            street = "Hoeger Mall",
            suite = "Apt.692",
            city = "South Elvis",
            zipcode =" 53919 - 4257",
            geo = GeoDTO(lat = "29.4572", lng = "-164.2990")
        ),
        phone = "493 - 170 - 9623 156",
        website = "kale.biz",
        company = CompanyDTO(
            name = "Robel - Corkery",
            catchPhrase = "Multi - tiered zero tolerance productivity",
            bs = "transition cutting -edge web services"
        )
    ),
    UserDTO(
        id = 5,
        name = "Chelsey Dietrich",
        username = "Kamren",
        email = "Lucio_Hettinger@ annie.ca",
        address = AddressDTO(
            street = "Skiles Walks",
            suite = "Suite 351",
            city = "Roscoeview",
            zipcode = "33263",
            geo = GeoDTO(lat = "-31.8129", lng = "62.5342")
        ),
        phone = "(254)954 - 1289",
        website = "demarco.info",
        company = CompanyDTO(
            name = "Keebler LLC",
            catchPhrase = "User - centric fault -tolerant solution",
            bs = "revolutionize end -to - end systems"
        )
    )
)