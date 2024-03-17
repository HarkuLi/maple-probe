from argparse import ArgumentParser, Namespace
import os
from pathlib import Path
import shutil

ICON_SUFFIX = '.info.icon.png'

def main():
    args = parse_args()

    Path(args.output).mkdir(parents=True, exist_ok=True)

    with os.scandir(args.source) as iterator:
        for f in iterator:
            if f.is_dir() and f.name.endswith('.img'):
                extract_icons(f, args.output)

def parse_args() -> Namespace:
    arg_parser = ArgumentParser()
    arg_parser.add_argument('source', help='source wz directory to extract')
    arg_parser.add_argument('output', help='output directory for extracted icons')

    return arg_parser.parse_args()

def extract_icons(dir: os.DirEntry[str], out_dir: str) -> None:
    inner_path = f'{dir.path}/{dir.name}'
    if is_empty_dir(inner_path):
        return

    with os.scandir(inner_path) as iterator:
        for f in iterator:
            if not f.is_file() or not f.name.endswith(ICON_SUFFIX):
                continue

            id = parse_id(f)
            shutil.copyfile(f.path, f'{out_dir}/{id}.png')

def parse_id(file: os.DirEntry[str]) -> str:
    return file.name.rstrip(ICON_SUFFIX).lstrip('0')

def is_empty_dir(path: str) -> bool:
    return len(os.listdir(path)) == 0

if __name__ == '__main__':
    main()
