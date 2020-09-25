package com.rezadev.moviecatalogue.utils


import com.rezadev.moviecatalogue.data.source.remote.response.MovieResponse
import com.rezadev.moviecatalogue.data.source.remote.response.MovieTvResponse

object FakeDataDummy {
    fun generateDummyMovie(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                1,
                "A Star is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "05/10/2018",
                "Bradley Cooper",
                "Drama, Romance, Music",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"
            )
        )
        movies.add(
            MovieResponse(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "14/02/2019",
                "Robert Rodriguez",
                "Action, Science Fiction, Adventure",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )
        movies.add(
            MovieResponse(
                3,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "21/12/2018",
                "James Wan",
                "Action, Adventure, Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"
            )
        )
        movies.add(
            MovieResponse(
                4,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "02/11/2018",
                "Bryan Singer",
                "Drama, Music",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )
        movies.add(
            MovieResponse(
                5,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "08/02/2019",
                "Hans Petter Moland",
                "Action, Crime, Thriller",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"
            )
        )
        movies.add(
            MovieResponse(
                6,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "21/11/2018",
                "Steven Caple Jr.",
                "Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"
            )
        )
        movies.add(
            MovieResponse(
                7,
                "Fantastic Beasts: The Crime of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. "
                + "\nThe only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "16/11/2018",
                "David Yates",
                "Adventure, Fantasy, Family",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uyJgTzAsp3Za2TaPiZt2yaKYRIR.jpg"
            )
        )
        movies.add(
            MovieResponse(
                8,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "18/01/2019",
                "M. Night Shyamalan",
                "Thriller, Drama, Science Fiction",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"
            )
        )
        movies.add(
            MovieResponse(
                9,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "22/02/2019",
                "Dean DeBlois",
                "Animation, Family, Adventure",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ij0xoc13hGhrYIlXGGuPXWTh3vi.jpg"
            )
        )
        movies.add(
            MovieResponse(
                10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "27/04/2018",
                "Joe Russo",
                "Adventure, Action, Science Fiction",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )
        return movies
    }
    fun generateDummyMovieTv(): List<MovieTvResponse> {
        val moviesTv = ArrayList<MovieTvResponse>()

        moviesTv.add(
            MovieTvResponse(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "Greg Berlanti",
                "Crime, Drama, Mystery, Action & Adventure",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                2,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "15/02/2019",
                "Jeremy Carver",
                "Sci-Fi & Fantasy, Action & Adventure",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                3,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "26/02/1986",
                "Akira Toriyama",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/y1OdtgB2HhZqPwzcAldXZy7dymB.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                4,
                "Fairy Tail x Rave",
                "In this crossover between two popular series, Fairy Tail x Rave follows the two groups as they discover their similarities with each other. As the miscommunications add up, they are pitted against one another in a heated clash of powers, but will have to work together against a common foe.",
                "03/02/2013",
                "Shinji Ishihira",
                "Animation, Action, Comedy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5QHj5lrF86pEbeCV9r9tsTPWYy5.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                5,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "31/01/1999",
                "Seth MacFarlane",
                "Animation, Comedy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                6,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "07/10/2014",
                "Greg Berlanti",
                "Drama, Sci-Fi & Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                7,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "22/09/2014",
                "Bruno Heller",
                "Drama, Fantasy, Crime",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                8,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "27/03/2005",
                "Shonda Rhimes",
                "Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mgOZSS2FFIGtfVeac1buBw3Cx5w.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                9,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "28/03/2019",
                "Shonda Rhimes",
                "Action & Adventure, Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg"
            )
        )

        moviesTv.add(
            MovieTvResponse(
                10,
                "Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "17/03/2017",
                "Scott Buck",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg"
            )
        )
        return moviesTv
    }
    fun getMovieById(id: Int) : MovieResponse? {
        for (movie in generateDummyMovie()) {
            if(id == movie.movieId) {
                return movie
            }
        }
        return null
    }

    fun getMovieTvById(id : Int) : MovieTvResponse? {
        for(movieTv in generateDummyMovieTv()) {
            if (id == movieTv.movieTvId) {
                return movieTv
            }
        }
        return null
    }
}