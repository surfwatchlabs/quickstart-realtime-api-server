require 'rubygems'
require 'sinatra'
require 'json'

post '/' do
  body = JSON.parse request.body.read
  puts body
end
