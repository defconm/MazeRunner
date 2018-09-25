" tltjr's .vimrc

" Start maximized
au GUIEnter * simalt ~x

" Basics
set backspace=start,indent,eol
set viminfo=\"20,%,'5,/10,:20,h,n~/.viminfo
set history=50
set laststatus=2
set showmode
set showcmd
set showmatch
set noerrorbells
set virtualedit=block
set title
set formatoptions=cqn1
set ffs=dos
set nofoldenable
set ignorecase
set ruler
set wildmenu
syntax on

set clipboard=unnamed

" No menus and no toolbar
set guioptions-=m
set guioptions-=T
set guioptions-=L
set guioptions-=r
" Consolas 15 point, ansi character set 
set guifont=Consolas:h13:cANSI

"####################################################################
"# Set Colorscheme
"# For future reference, colorschemes can be found in,
"# /usr/share/vim/vim72/colors/
"####################################################################
colorscheme molokai

"####################################################################
"#
"# The Status Line
"#
"####################################################################
set statusline=%f%=%1*[%Y%R%M]%*

"####################################################################
"#
"# FileType Support
"#
"####################################################################
filetype on
filetype plugin on
filetype indent on

"####################################################################
"#
"# Programming Stuff
"#
"####################################################################
set path+=include
set path+=lib
set tabstop=2
set softtabstop=2
set shiftwidth=2
set smarttab
set expandtab
set textwidth=78
set autoindent
set relativenumber

map <Space> "_

command Tail setlocal autoread

"####################################################################
"# sass
autocmd BufRead,BufNewFile *.scss set filetype=scss

"####################################################################
"# C#
" autocmd BufRead,BufNewFile *.cs set filetype=csharp
" Map razor files to html for syntax highlighting
autocmd BufRead,BufNewFile *.cshtml set filetype=html
" Map xaml files to xml for syntax highlighting
autocmd BufRead,BufNewFile *.xaml set filetype=xml
" Map config files to xml for syntax highlighting
autocmd BufRead,BufNewFile *.config set filetype=xml
" Map vstemplate files to xml for syntax highlighting
autocmd BufRead,BufNewFile *.vstemplate set filetype=xml

au BufRead,BufNewFile *.ts set filetype=typescript

"let g:OmniSharp_selector_ui = 'unite' " Use unite.vim

"####################################################################
"# Ruby
autocmd BufRead,BufNewFile Rakefile set filetype=ruby
autocmd BufRead,BufNewFile rakefile set filetype=ruby
autocmd BufRead,BufNewFile *.rake   set filetype=ruby
autocmd BufRead,BufNewFile .irbrc   set filetype=ruby
autocmd BufRead,BufNewFile *.rjs    set filetype=ruby

au BufRead,BufNewFile *.feature set filetype=cucumber

"####################################################################
"# Rust
autocmd BufRead,BufNewFile *.rs set filetype=rust

"####################################################################
"# Clojure
let vimclojure#HighlightBuiltins = 1
let vimclojure#ParenRainbow = 1
au BufRead,BufNewFile *.clj set filetype=clojure

"####################################################################
"# clisp
let g:lisp_rainbow=1

"####################################################################
"# pathogen
execute pathogen#infect()

"####################################################################
"# below is from article on buffer usage found here:
"# http://joshldavis.com/2014/04/05/vim-tab-madness-buffers-vs-tabs/

"####################################################################
"# airline
" Enable the list of buffers
let g:airline#extensions#tabline#enabled = 1

" Show just the filename
let g:airline#extensions#tabline#fnamemod = ':t'

" Use Molokai theme
let g:airline_theme='molokai'

" Map leader to ','
let mapleader = ","

" This allows buffers to be hidden if you've modified a buffer.
" This is almost a must if you wish to use buffers in this way.
" set hidden

" To open a new empty buffer
" This replaces :tabnew which I used to bind to this mapping
nmap <leader>T :enew<cr>

" Move to the next buffer
nmap <leader>l :bnext<CR>

" Move to the previous buffer
nmap <leader>h :bprevious<CR>

" Close the current buffer and move to the previous one
" This replicates the idea of closing a tab
nmap <leader>bq :bp <BAR> bd #<CR>

" Show all open buffers and their status
nmap <leader>bl :ls<CR>


