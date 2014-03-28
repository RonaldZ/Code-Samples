function love.draw()
	data = love.image.newImageData(800,600)
	noise1 = 0
	noise2 = 0
	noise3 = 0
	for i=0, data:getWidth()-1 do   -- remember: start at 0
		for j = 0, data:getHeight()-1 do
			noise1 = love.math.noise(i, j)
			noise2 = love.math.noise(j/16, i/16)
			noise3 = love.math.noise(noise1, noise2)
			data:setPixel(i, j, 255, 255, 255, noise3*255)
		end
	end
	img = love.graphics.newImage(data)
	love.graphics.draw(img)
end