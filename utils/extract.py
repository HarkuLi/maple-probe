from argparse import ArgumentParser, Namespace
import os
from pathlib import Path
import shutil

def main():
    args = parse_args()

    Path(args.output).mkdir(parents=True, exist_ok=True)

    with os.scandir(args.source) as iterator:
        for f in iterator:
            if f.is_dir() and f.name.endswith('.img'):
                extract_icon(f, args.output)

def parse_args() -> Namespace:
    arg_parser = ArgumentParser()
    arg_parser.add_argument('source', help='source wz directory to extract')
    arg_parser.add_argument('output', help='output directory for extracted icons')

    return arg_parser.parse_args()

def extract_icon(dir: os.DirEntry[str], out_dir: str) -> None:
    id = parse_id(dir)

    inner_path = f'{dir.path}/{dir.name}'
    if is_empty_dir(inner_path):
        return

    icon_types = [
        'stand.0',
        'fly.0',
        'info.default.0',
        'info.icon',
    ]

    for icon_type in icon_types:
        icon_path = f'{inner_path}/{icon_type}.png'
        if os.path.exists(icon_path):
            shutil.copyfile(icon_path, f'{out_dir}/{id}.png')
            return

    print(f'ID `{id}` is skipped due to icon path `{inner_path}/<icon_type>.png` not found.')

def parse_id(dir: os.DirEntry[str]) -> str:
    return dir.name.rstrip('.img').lstrip('0')

def is_empty_dir(path: str) -> bool:
    return len(os.listdir(path)) == 0

if __name__ == '__main__':
    main()
