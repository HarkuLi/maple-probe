# Maprobe

Web-based GUI for interacting with [Cosmic][]/[HeavenMS][] MapleStory v83
server.

[Cosmic]: https://github.com/P0nk/Cosmic
[HeavenMS]: https://github.com/ronancpl/HeavenMS

## Prerequisite

1.  [GNU Make](https://www.gnu.org/software/make)
2.  [Docker](https://www.docker.com)
3.  [Docker Compose](https://docs.docker.com/compose/install)

## Get Started

1.  Run the database of Cosmic or HeavenMS.

    ```bash
    // Under the directory of Cosmic/HeavenMS.
    docker compose up -d db
    ```

2.  Create `.env` file

    ```bash
    make .env
    ```

3.  Edit settings in `.env` file if necessary.

4.  (optional) Place item and monster images named by IDs under the
    [frontend/public/images](./frontend/public/images) directory like

    ```
    images
    ├── items
    │   ├── .gitignore
    │   ├── 1000000.png
    │   ├── ...
    │   └── 4310000.png
    └── monsters
        ├── .gitignore
        ├── 100100.png
        ├── ...
        ├── 9999999.png
        └── default.png
    ```

    > The images can be extracted from
    [Item.wz and Mob.wz](https://github.com/P0nk/Cosmic-client/tree/main/cosmic-wz)
    using [Harepacker](https://github.com/lastbattle/Harepacker-resurrected).

5.  Start Maprobe.

    ```bash
    make up
    ```

6.  Access Maprobe at [localhost:8080](localhost:8080).
    *   The listening port might not be `8080` if you have changed the
        `FRONTEND_PORT` setting in `.env` file.

7.  You can stop Maprobe by

    ```bash
    make down
    ```
